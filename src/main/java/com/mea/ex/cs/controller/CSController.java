package com.mea.ex.cs.controller;

import com.mea.ex.cs.domain.Customer;
import com.mea.ex.cs.domain.CustomerRole;
import com.mea.ex.cs.repository.CustomerHistoryRepository;
import com.mea.ex.cs.repository.CustomerRepository;
import com.mea.ex.cs.service.CSService;
import com.mea.ex.support.BeanUtils;
import com.mea.ex.test.TestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CSController {

    @Autowired
    private CSService csService;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/test")
    public String test(){

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

        return "test";
    }

    @GetMapping("/cs/{id}")
    public Customer findById(@PathVariable Long id, Model model){

        System.out.println(">>>>>>>>>>>"+id);
        System.out.println(csService.findById(id).toString());
        return csService.findById(id);
    }
}
