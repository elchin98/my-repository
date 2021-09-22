package com.example.mvcproject.mvcprojectspring.controller;

//import com.example.restintroacer.model.CustomRestError;
import com.example.mvcproject.mvcprojectspring.model.CustomError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindException;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
//import java.net.BindException;
import java.util.ArrayList;

@Slf4j
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handle (HttpServletRequest req, Exception ex){
        log.error("Error occured");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error");
        mv.addObject("url", req.getRequestURL());
        mv.addObject("error",new CustomError("Test error message"));

        return  mv;
      //  return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ModelAndView handle (HttpServletRequest req , BindException ex){
        log.error("Error occured",ex);
        ModelAndView mv = new ModelAndView();

        ArrayList <String> details = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            details.add(error.getField() + ":" + error.getDefaultMessage());
        }
        mv.setViewName("error");
        mv.addObject("url",req.getRequestURL());
        mv.addObject("error", details.toString());
        return mv ;
    }



}
