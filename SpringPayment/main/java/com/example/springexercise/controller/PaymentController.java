package com.example.springexercise.controller;


import com.example.springexercise.dao.entity.PaymentEntity;
import com.example.springexercise.service.PaymentService;;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;

@Controller
public class PaymentController {

    private  PaymentService paymentService;

    PaymentController (PaymentService paymentService){

        this.paymentService = paymentService;
    }

    @GetMapping("/list")
    public String getPayment (Model model){
        var list= paymentService.getPayment();
        model.addAttribute("payments",list );

        return  "list";
    }

    @GetMapping
    public String addPayment(Model model){

    model.addAttribute("payment",new PaymentEntity());

        return "/add";
    }

    @PostMapping("/add")
    public String savePayment(@ModelAttribute ("payment") Model model, PaymentEntity payment){
        paymentService.savePayment(payment);

        return "redirect:/list" ;
    }


    @GetMapping("/{id}")
    public String getPaymenId( Model model , @PathVariable  Long id) {
         var pr = paymentService.getPaymentId(id);
         model.addAttribute("payment" , pr);
        return  "edit";
    }

    @PostMapping("/edit/{id}")
    public String editPayment(@ModelAttribute("payment") PaymentEntity paymentEntity ,
                              @PathVariable Long id , BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
             return  "edit";
        }

        var py = paymentService.updatePayment(paymentEntity, id);
        return  "redirect:/list";

    }

    @GetMapping("/soft/delete/{id}")
    public String  softDelete (@PathVariable Long id){
        paymentService.softDelete(id);
        return  "redirect:/list" ;
    }
}
