package com.example.mvcproject.mvcprojectspring.service;

import com.example.mvcproject.mvcprojectspring.dao.entity.ProductEntity;


import java.util.List;
import java.util.Set;

public interface ProductService {

    List<ProductEntity> getProduct();
    void saveProduct(ProductEntity product);

    ProductEntity getProductsId(Long id);

    ProductEntity updateProduct (Long id ,ProductEntity product);

    void hardDeleteProduct (Long id);

    void softDeleteProduct (Long id);

}
