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
        Customer customer = new Customer();
        customer.setName("테스트1");
        customer.setComment("테스트1 코멘트");
        customer.setEmail("aa@aa.com");
        customer.setCreateAt(LocalDateTime.now());
        customer.setUpdateAt(LocalDateTime.now());

        Customer customer1 = Customer.builder()
                .name("테스트2")
                .comment("테스트2 코멘트")
                .email("bb@bb.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();
        Customer customer2 = Customer.builder()
                .name("테스트3")
                .comment("테스트3 코멘트")
                .email("cc@cc.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        customerRepository.save(customer);
        customerRepository.save(customer1);
        customerRepository.save(customer2);

//        Customer customer = new Customer();
//        customer.setName("테스트1");
//        customer.setComment("테스트1 코멘트");
//        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("의미없다", contains());
//        Example<Customer> example = Example.of(customer, matcher);
//        System.out.println(matcher);
//        System.out.println(example);
//        customerRepository.findAll(example).forEach(System.out::println);
    }

    @Test
    void select(){
        System.out.println("findByName >"+customerRepository.findByName("테스트1"));
        System.out.println("findByEmail >"+customerRepository.findByEmail("aa@aa.com"));
        System.out.println("getByEmail >"+customerRepository.getByEmail("bb@bb.com"));
        System.out.println("readByEmail >"+customerRepository.readByEmail("cc@cc.com"));
        System.out.println("queryByEmail >"+customerRepository.queryByEmail("aa@aa.com"));
        System.out.println("searchByEmail >"+customerRepository.searchByEmail("bb@bb.com"));
        System.out.println("streamByEmail >"+customerRepository.streamByEmail("cc@cc.com"));
//        System.out.println("findCustomerByEmail >"+customerRepository.findCustomerEmail("aa@aa.com"));
        System.out.println("findFirst2ByName >"+customerRepository.findFirst2ByName("테스트2"));
        System.out.println("findTop2ByName >"+customerRepository.findTop2ByName("테스"));
        System.out.println("findLast1ByName >"+customerRepository.findLast1ByName("테"));
    }
}