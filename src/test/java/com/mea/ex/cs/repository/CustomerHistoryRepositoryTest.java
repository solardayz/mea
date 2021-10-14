package com.mea.ex.cs.repository;

import com.mea.ex.cs.domain.Customer;
import com.mea.ex.cs.domain.CustomerHistory;
import com.mea.ex.cs.domain.CustomerRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerHistoryRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerHistoryRepository customerHistoryRepository;

    @Test
    void oneAndNTest(){
        Customer customer = new Customer();
        customer.setName("테스트");
        customer.setComment("테스트 코멘트");
        customer.setRole(CustomerRole.BOSS);
        customer.setEmail("test@clc.com");
        customerRepository.save(customer);

        customer.setName("테스트1");

        customerRepository.save(customer);


//        List<CustomerHistory> customerHistoryList= customerRepository.findByEmail("test@clc.com").getCustomerHistoryList();

//        customerHistoryList.forEach(System.out::println);
        //System.out.println(customerHistoryList);
        //customerHistoryRepository.findAll().forEach(System.out::println);
//        customerHistoryRepository.findByCustomerId(customer.getId()).forEach(System.out::println);

//        customerHistoryRepository.findByComment(customer.getComment()).forEach(System.out::println);
    }

    @Test
    @Transactional
    void nAndOneTest(){
        baseInsert();
        Customer customer = customerRepository.getById(1L);
        System.out.println(customer);

        List<CustomerHistory> customerHistory = customer.getCustomerHistoryList();
        System.out.println(customerHistory);

//        customerHistoryRepository.findAll().forEach(System.out::println);

//        System.out.println(customerHistoryRepository.getById(1L).getCustomer());
//        Customer customer1 = customerHistoryRepository.findAll().get(0).getCustomer();
//        System.out.println(customer1);

//        CustomerHistory customerHistory = customerHistoryRepository.getById(1L);
    }

    @Test
    void baseInsert(){

        Customer customer = new Customer();
        customer.setName("테스트");
        customer.setComment("테스트 코멘트");
        customer.setRole(CustomerRole.BOSS);
        customer.setEmail("test@clc.com");
        customerRepository.save(customer);

        customer.setName("테스트1");

        customerRepository.save(customer);

        System.out.println(customer);
        System.out.println(customer.getCustomerHistoryList());
    }
}