package com.mea.ex.cs.controller;

import com.mea.ex.cs.domain.Customer;
import com.mea.ex.cs.domain.Role;
import com.mea.ex.cs.repository.CustomerRepository;
import com.mea.ex.cs.service.CSService;
import com.mea.ex.test.TestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class CSController {

    @Autowired
    private CSService csService;

//    @Autowired
//    private TestData testData;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/cs/{id}")
    public Customer findById(@PathVariable Long id, Model model){
//        testData.basicInsert();
        System.out.println(">>>>>>>>>>>"+id);
        return csService.findById(id);
    }
}
