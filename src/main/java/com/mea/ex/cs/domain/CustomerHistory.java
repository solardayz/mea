package com.mea.ex.cs.domain;

import com.mea.ex.listener.Auditable;
import com.mea.ex.listener.BaseEntity;
import com.mea.ex.listener.CustomerEntityListener;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
public class CustomerHistory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    private String comment;

//    @Column(name = "customer_id")
//    private Long customerId;

    @Enumerated(EnumType.STRING)
    private CustomerRole role;

    private String email;

//    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
    private Customer customer;
}
