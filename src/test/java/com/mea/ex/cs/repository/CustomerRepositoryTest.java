package com.mea.ex.cs.repository;

import com.mea.ex.cs.domain.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void crud(){
//        Customer customer = new Customer();
//        customer.setName("테스트2");
//        customer.setComment("테스트2 코멘트");
//        customer.setCreateAt(LocalDateTime.now());
//        customer.setUpdateAt(LocalDateTime.now());
//
//        Customer customer1 = Customer.builder()
//                .name("테스트3")
//                .comment("테스트3 코멘트")
//                .createAt(LocalDateTime.now())
//                .updateAt(LocalDateTime.now())
//                .build();
//
//        customerRepository.save(customer);
//        customerRepository.save(customer1);

        Customer customer = new Customer();
        customer.setName("테스트1");
        customer.setComment("테스트1 코멘트");
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("의미없다", contains());
        Example<Customer> example = Example.of(customer, matcher);
        System.out.println(matcher);
        System.out.println(example);
        customerRepository.findAll(example).forEach(System.out::println);
    }
}