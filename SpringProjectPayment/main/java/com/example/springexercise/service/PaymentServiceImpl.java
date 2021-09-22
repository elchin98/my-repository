package com.example.springexercise.service;


import com.example.springexercise.dao.entity.PaymentEntity;
import com.example.springexercise.dao.entity.PaymentStatus;
import com.example.springexercise.dao.repository.PaymentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
@Slf4j
@Service
@Profile("prod")
public class PaymentServiceImpl implements PaymentService {
    PaymentRepository  paymentRepository ;

    public PaymentServiceImpl (PaymentRepository paymentRepository){
        this.paymentRepository=paymentRepository;
    }


    public void savePayment (PaymentEntity payment){
        log.info("Save method started");
        if (payment.getAmount().compareTo(BigDecimal.ZERO)<0){
            throw new RuntimeException("amount less than 0");
        }
        payment.setStatus(PaymentStatus.CREATED);
        paymentRepository.save(payment);

        log.info("Save method end");
    }


    public PaymentEntity getPaymentId(Long id) {
        Optional<PaymentEntity> entityOptional=paymentRepository.findById(id);
        if(entityOptional.isPresent()){
            return  entityOptional.get();
        }
        return new PaymentEntity();
    }

    @Override
    public PaymentEntity updatePayment(PaymentEntity paymentEntity, Long id) {
    Optional<PaymentEntity> optionalPaymentEntity = paymentRepository.findById(id);
    if (optionalPaymentEntity.isEmpty()){
        throw  new RuntimeException("Object  dont find");
    }
        PaymentEntity py = optionalPaymentEntity.get();
        py.setAmount(paymentEntity.getAmount());
        py.setCurrency(paymentEntity.getCurrency());
        py.setDescription(paymentEntity.getDescription());

        return py;
    }

    @Override
    public void softDelete(Long id) {
        Optional<PaymentEntity> optionalPaymentEntity=paymentRepository.findById(id);
        if(optionalPaymentEntity.isEmpty()){
            throw  new RuntimeException("Payment dont find");
        }

        PaymentEntity py = optionalPaymentEntity.get();
        py.setStatus(PaymentStatus.DELETED);

        paymentRepository.save(py);
    }

    @Override
    public Set<PaymentEntity> getPayment() {

        var list = paymentRepository.findAllByStatusIsNotInOrderByUpdatedAtDesc(PaymentStatus.DELETED);
        return  list;
    }




}
