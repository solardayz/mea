package com.mea.ex.cs.repository;

import com.mea.ex.cs.domain.Customer;
import com.mea.ex.cs.domain.CustomerHistory;
import com.mea.ex.cs.domain.CustomerRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
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

    @Commit
    @Transactional
    @Test
//    @Transactional
    void onetomanyDirection(){

        Customer customer = Customer.builder()
                .name("juna")
                .comment("BOSS")
                .role(CustomerRole.BOSS)
                .email("juna@clc.com")
                .build();
        customerRepository.save(customer);

        CustomerHistory customerHistory = new CustomerHistory();
        customerHistory.setName(customer.getName());
        customerHistory.setEmail(customer.getEmail());
        customerHistory.setComment(customer.getComment());
        customerHistory.setRole(customer.getRole());

//        customer.addCustomerHistory(customerHistory);

        customerHistoryRepository.save(customerHistory);

        customer.setComment("커멘트변경");
        customerRepository.save(customer);


        CustomerHistory customerHistory1 = new CustomerHistory();
        customerHistory1.setName(customer.getName());
        customerHistory1.setEmail(customer.getEmail());
        customerHistory1.setComment(customer.getComment());
        customerHistory1.setRole(customer.getRole());

//        customer.addCustomerHistory(customerHistory1);

        customerHistoryRepository.save(customerHistory1);

        System.out.println(customer);
        customerHistoryRepository.findAll().forEach(System.out::println);

    }

    @Commit
    @Test
    @Transactional
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

        System.out.println(customer1.toString());
        customerHistoryRepository.findAll().forEach(System.out::println);
    }
}