package com.example.springexercise.dao.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
public class PaymentEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt ;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "currency")
    private String currency;

    @Column(name = "status")
    private PaymentStatus status;


    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "payment", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PaymentBankEntity bankPayments ;





}
