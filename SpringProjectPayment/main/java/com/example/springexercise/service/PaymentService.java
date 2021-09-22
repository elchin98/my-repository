package com.example.springexercise.service;

import com.example.springexercise.dao.entity.PaymentEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface PaymentService {


     Set<PaymentEntity> getPayment ();

     void savePayment (PaymentEntity payment);


     PaymentEntity getPaymentId (Long id);


     PaymentEntity updatePayment(PaymentEntity paymentEntity, Long id);

     void softDelete(Long id );
}
