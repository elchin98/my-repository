package com.example.springexercise.dao.repository;

import com.example.springexercise.dao.entity.PaymentEntity;
import com.example.springexercise.dao.entity.PaymentStatus;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface PaymentRepository extends JpaRepository<PaymentEntity,Long> {

    @Query(value = "SELECT * from  payments where status not in ?1 order by updated_at desc ", nativeQuery = true)
     Set<PaymentEntity> findAllWithNativeQuery(String...statuses);


    Set<PaymentEntity> findAllByStatusIsNotInOrderByUpdatedAtDesc(PaymentStatus...statuses);

}
