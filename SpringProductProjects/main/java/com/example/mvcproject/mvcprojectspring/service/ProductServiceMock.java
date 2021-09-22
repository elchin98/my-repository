//package com.example.mvcproject.mvcprojectspring.service;
//
//import com.example.mvcproject.mvcprojectspring.model.Product;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@Profile("dev")
//public class ProductServiceMock implements ProductService {
//
//    public List<Product> getProduct (){
//        return  readlist();
//    }
//
//
//    private List<Product> readlist(){
//        List<Product> list = new ArrayList<>();
//        Product i = new Product("Phone","Yellow",5, LocalDateTime.now());
//        Product i2 = new Product("Laptop","Black",10, LocalDateTime.now());
//        Product i3 = new Product("Car","Red",7, LocalDateTime.now());
//        list.add(i);
//        list.add(i2);
//        list.add(i3);
//
//        return  list;
//
//    }
//    @Override
//    public void saveProduct(Product item) {
//
//    }
//}
