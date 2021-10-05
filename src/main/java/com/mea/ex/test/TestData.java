package com.mea.ex.test;

import com.mea.ex.cs.domain.Customer;
import com.mea.ex.cs.domain.Role;
import com.mea.ex.cs.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class TestData {

    @Autowired
    private CustomerRepository customerRepository;

    public void basicInsert(){
        Customer customer1 = Customer.builder()
                .name("juna")
                .comment("BOSS")
                .role(Role.BOSS)
                .email("juna@clc.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .name("auna")
                .comment("MANAGER")
                .role(Role.MANAGER)
                .email("auna@clc.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .name("euna")
                .comment("USER")
                .role(Role.USER)
                .email("euna@cha.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        Customer customer4 = Customer.builder()
                .name("buna")
                .comment("USER")
                .role(Role.USER)
                .email("buna@cha.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        Customer customer5 = Customer.builder()
                .name("quna")
                .comment("USER")
                .role(Role.USER)
                .email("quna@clc.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();


        Customer customer6 = Customer.builder()
                .name("juna")
                .comment("USER")
                .role(Role.USER)
                .email("juna@clc.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);
        customerRepository.save(customer6);

    }
}
