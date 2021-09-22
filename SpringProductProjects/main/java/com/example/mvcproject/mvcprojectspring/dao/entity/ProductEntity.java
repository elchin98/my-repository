package com.example.mvcproject.mvcprojectspring.dao.entity;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
        @Id
        @Column(name="id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;


        @Column(name = "name")
        @NotBlank
        @Length(min = 4 , max = 20)
        private String name ;

        @Column(name = "price")
        private BigDecimal price ;

        @Column(name ="category")
        private String category;

        @Enumerated(EnumType.STRING)
        @Column(name = "status")
        private ProductStatus status;

        @CreationTimestamp
        @Column(name = "created_at")
        private LocalDateTime createdAt;

        @UpdateTimestamp
        @Column(name = "updated_adt")
        private LocalDateTime updatedAt;

        @ToString.Exclude
        @EqualsAndHashCode.Exclude
        @OneToMany(mappedBy = "product" ,fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
        private Set<ProductOrderEntity> orders ;

}
