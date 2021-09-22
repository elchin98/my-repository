package com.example.mvcproject.mvcprojectspring.service;

import com.example.mvcproject.mvcprojectspring.dao.entity.ProductEntity;
import com.example.mvcproject.mvcprojectspring.dao.entity.ProductStatus;
import com.example.mvcproject.mvcprojectspring.dao.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.*;
@Slf4j
@Service
@Profile("prod")
public class ProductServiceImpl implements  ProductService {
    //List<ProductEntity> list = new ArrayList<>();
    int id =0;
   private final  ProductRepository productRepository;

   public ProductServiceImpl (ProductRepository productRepository){

       this.productRepository=productRepository;
   }


    public List<ProductEntity> getProduct(){
//    return productRepository.findAllByStatusIsNotInOrderByUpdatedAtDesc(ProductStatus.DELETED);
         return  productRepository.findAllWithNativeQUery(ProductStatus.DELETED.toString());
    //   return  productRepository.findAllWithQuery(ProductStatus.DELETED);
    }




    public void saveProduct(ProductEntity product){
       product.setStatus(ProductStatus.CREATED);
       productRepository.save(product);
    }

    public ProductEntity getProductsId(Long id ) {
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        if (optionalProductEntity.isPresent()) {
            return optionalProductEntity.get();
        }
        return  new ProductEntity();
    }


    public ProductEntity updateProduct (Long id ,ProductEntity product){
       log.info("Method started");
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        if (optionalProductEntity.isEmpty()) {
            throw  new RuntimeException("Error occured");
        }
        log.debug("Product updating started");
        ProductEntity pr = optionalProductEntity.get();

        pr.setName(product.getName());
        pr.setPrice(product.getPrice());
        pr.setCategory(product.getCategory());
        log.debug("Product updating finished");
        productRepository.save(pr);
        log.info("Method end");
        return  pr;


    }

    public  void  hardDeleteProduct(Long id){

       productRepository.deleteById(id);
    }


    public void softDeleteProduct (Long id){
        Optional<ProductEntity> optionalProductEntity = productRepository.findById(id);
        if (optionalProductEntity.isEmpty()) {
            throw  new RuntimeException("Error occured");
        }
        ProductEntity pr = optionalProductEntity.get();
        pr.setStatus(ProductStatus.DELETED);
        productRepository.save(pr);

    }
}
