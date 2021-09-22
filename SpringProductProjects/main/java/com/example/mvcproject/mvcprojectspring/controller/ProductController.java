package com.example.mvcproject.mvcprojectspring.controller;

import com.example.mvcproject.mvcprojectspring.dao.entity.ProductEntity;
import com.example.mvcproject.mvcprojectspring.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
   private ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;

    }

        @GetMapping("/list")
        public String getList(Model model){
        var list =productService.getProduct();
        model.addAttribute("products",list);
        return "list";
        }


        @PostMapping("/add")
        public String  saveProduct( @ModelAttribute ("product") ProductEntity product){

            productService.saveProduct(product);

            return  "redirect:/list";
    }

        @GetMapping("/")
        public String getProductList(Model model){
        model.addAttribute("product",new ProductEntity());
       // throw  new ArithmeticException();
            return  "/add";
        }

        @GetMapping("/{id}")
    public String getProductsId(@PathVariable  Long id, Model model){
         var pr =productService.getProductsId(id);
         model.addAttribute("product",pr);
        return  "edit";
        }

        @PostMapping("/edit/{id}")
    public String editProduct (@PathVariable Long id , @ModelAttribute ProductEntity product){
        var pr = productService.updateProduct( id,product);
        return  "redirect:/list";
        }

    @PostMapping("/delete/{id}")
    public String deleteProduct (@PathVariable Long id , Model model){
         productService.hardDeleteProduct(id);
         var list =productService.getProduct();
        model.addAttribute("products",list);
        return  "list";
    }

    @GetMapping("/soft/delete/{id}")
    public String softDeleteProduct (@PathVariable Long id ){
        productService.softDeleteProduct(id);
        return  "redirect:/list";
    }
}
