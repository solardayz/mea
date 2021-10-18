package com.mea.ex.cs.repository;

import com.mea.ex.cs.domain.Customer;
import com.mea.ex.cs.domain.CustomerHistory;
import com.mea.ex.cs.domain.CustomerRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

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
//    @Transactional
     void nAndOneTest(){
         Customer customer1 = Customer.builder()
                 .name("juna")
                 .comment("BOSS")
                 .role(CustomerRole.BOSS)
                 .email("juna@clc.com")
//                .createAt(LocalDateTime.now())
//                .updateAt(LocalDateTime.now())
                 .build();
         customerRepository.save(customer1);

         System.out.println(customer1);

//        customer.setComment("변경합니다.");
//        customerRepository.save(customer);

//        System.out.println(customer);

//        customerHistoryRepository.findAll().forEach(System.out::println);

//        List<CustomerHistory> customerHistory = customer.getCustomerHistoryList();
//        System.out.println(customerHistory);

//        customerHistoryRepository.findAll().forEach(System.out::println);

//        System.out.println(customerHistoryRepository.getById(1L).getCustomer());
//        Customer customer1 = customerHistoryRepository.findAll().get(0).getCustomer();
//        System.out.println(customer1);

//        CustomerHistory customerHistory = customerHistoryRepository.getById(1L);
    }

    @Test
//    @Transactional
    void baseInsert(){

        Customer customer1 = Customer.builder()
                .name("juna")
                .comment("BOSS")
                .role(CustomerRole.BOSS)
                .email("juna@clc.com")
//                .createAt(LocalDateTime.now())
//                .updateAt(LocalDateTime.now())
                .build();

//        Customer customer2 = Customer.builder()
//                .name("auna")
//                .comment("MANAGER")
//                .role(CustomerRole.MANAGER)
//                .email("auna@clc.com")
////                .createAt(LocalDateTime.now())
////                .updateAt(LocalDateTime.now())
//                .build();
//
//        Customer customer3 = Customer.builder()
//                .name("euna")
//                .comment("USER")
//                .role(CustomerRole.USER)
//                .email("euna@cha.com")
////                .createAt(LocalDateTime.now())
////                .updateAt(LocalDateTime.now())
//                .build();
//
//        Customer customer4 = Customer.builder()
//                .name("buna")
//                .comment("USER")
//                .role(CustomerRole.USER)
//                .email("buna@cha.com")
////                .createAt(LocalDateTime.now())
////                .updateAt(LocalDateTime.now())
//                .build();
//
//        Customer customer5 = Customer.builder()
//                .name("quna")
//                .comment("USER")
//                .role(CustomerRole.USER)
//                .email("quna@clc.com")
////                .createAt(LocalDateTime.now())
////                .updateAt(LocalDateTime.now())
//                .build();
//
//
//        Customer customer6 = Customer.builder()
//                .name("juna")
//                .comment("USER")
//                .role(CustomerRole.USER)
//                .email("juna@clc.com")
////                .createAt(LocalDateTime.now())
////                .updateAt(LocalDateTime.now())
//                .build();

        customerRepository.save(customer1);
//        customerRepository.save(customer2);
//        customerRepository.save(customer3);
//        customerRepository.save(customer4);
//        customerRepository.save(customer5);
//        customerRepository.save(customer6);
    }
}