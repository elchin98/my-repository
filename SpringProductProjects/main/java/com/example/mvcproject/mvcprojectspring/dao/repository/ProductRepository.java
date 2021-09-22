package com.example.mvcproject.mvcprojectspring.dao.repository;

import com.example.mvcproject.mvcprojectspring.dao.entity.ProductEntity;
import com.example.mvcproject.mvcprojectspring.dao.entity.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

     List<ProductEntity> findAllByStatusIsNotInOrderByUpdatedAtDesc(ProductStatus...statuses);

     @Query("select p from ProductEntity p where p.status not in ?1 order by p.updatedAt desc")
     List<ProductEntity> findAllWithQuery(ProductStatus...statuses);

     @Query(value = "select * from product where status not in ?1  order by  updated_adt desc" , nativeQuery =true)
     List<ProductEntity> findAllWithNativeQUery(String...status);
}
