package com.example.springexercise.dao.entity;


import lombok.*;

import javax.persistence.*;
//import javax.;

@Entity
@Table(name ="bank_payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentBankEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

//    @NotBlank;
    @Column(name = "name")
    private  String name ;

    @Column(name = "description")
    private  String description ;

    @Column(name = "form")
    private  String form ;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "payments_id")
    private PaymentEntity payment;

}
