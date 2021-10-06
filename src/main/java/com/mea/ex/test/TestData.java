package com.mea.ex.test;

import com.mea.ex.cs.domain.Customer;
import com.mea.ex.cs.domain.CustomerRole;
import com.mea.ex.cs.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class TestData {

    @Autowired
    private CustomerRepository customerRepository;

    public void basicInsert(){
        Customer customer1 = Customer.builder()
                .name("juna")
                .comment("BOSS")
                .role(CustomerRole.BOSS)
                .email("juna@clc.com")
//                .createAt(LocalDateTime.now())
//                .updateAt(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .name("auna")
                .comment("MANAGER")
                .role(CustomerRole.MANAGER)
                .email("auna@clc.com")
//                .createAt(LocalDateTime.now())
//                .updateAt(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .name("euna")
                .comment("USER")
                .role(CustomerRole.USER)
                .email("euna@cha.com")
//                .createAt(LocalDateTime.now())
//                .updateAt(LocalDateTime.now())
                .build();

        Customer customer4 = Customer.builder()
                .name("buna")
                .comment("USER")
                .role(CustomerRole.USER)
                .email("buna@cha.com")
//                .createAt(LocalDateTime.now())
//                .updateAt(LocalDateTime.now())
                .build();

        Customer customer5 = Customer.builder()
                .name("quna")
                .comment("USER")
                .role(CustomerRole.USER)
                .email("quna@clc.com")
//                .createAt(LocalDateTime.now())
//                .updateAt(LocalDateTime.now())
                .build();


        Customer customer6 = Customer.builder()
                .name("juna")
                .comment("USER")
                .role(CustomerRole.USER)
                .email("juna@clc.com")
//                .createAt(LocalDateTime.now())
//                .updateAt(LocalDateTime.now())
                .build();

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);
        customerRepository.save(customer6);

    }
}
