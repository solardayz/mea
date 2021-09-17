package com.mea.ex.cs.controller;

import com.mea.ex.cs.domain.Customer;
import com.mea.ex.cs.service.CSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CSController {

    @Autowired
    private CSService csService;

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    public Customer findById(@PathVariable Long id, Model model){
        return csService.findById(id);
    }
}
