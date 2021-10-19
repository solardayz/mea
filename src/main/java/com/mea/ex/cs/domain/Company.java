package com.mea.ex.cs.domain;

import com.mea.ex.listener.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Company extends BaseEntity {

    @Id
    @Column(name = "companyId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    @ToString.Exclude
    @JoinColumn(name = "companyId")
    private List<Customer> customerList = new ArrayList<Customer>();

    public void addCustomer(Customer customer){
        if(this.customerList == null){
            this.customerList = new ArrayList<>();
        }
        this.customerList.add(customer);

    }

}
