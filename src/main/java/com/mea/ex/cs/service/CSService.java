package com.mea.ex.cs.service;

import com.mea.ex.cs.domain.Customer;
import com.mea.ex.cs.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CSService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional(readOnly = true)
    public Customer findById(Long id){
        return customerRepository.getById(id);
    }

}
