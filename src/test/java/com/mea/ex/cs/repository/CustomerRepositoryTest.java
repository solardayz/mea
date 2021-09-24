package com.mea.ex.cs.repository;

import com.mea.ex.cs.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void crud(){
        Customer customer = new Customer();
        customer.setName("테스트");
        customer.setComment("테스트 코멘트");
        customer.setCreateAt(LocalDateTime.now());
        customer.setUpdateAt(LocalDateTime.now());

        Customer customer1 = Customer.builder()
                .name("테스트1")
                .comment("테스트1 코멘트")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        customerRepository.save(customer);
        customerRepository.save(customer1);
    }
}