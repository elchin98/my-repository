package com.example.springexercise.controller;


import com.example.springexercise.model.CustomError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handle (Exception exception, HttpServletRequest request){

        ModelAndView m = new ModelAndView();
        m.setViewName("error");
        m.addObject("url",request.getRequestURL());
        m.addObject("error", new CustomError("Error occured"));

        log.error("error occurred",exception);
        log.debug("Method end");

        return m;
    }

}
