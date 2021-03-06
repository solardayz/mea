package com.mea.ex.listener;

import com.mea.ex.cs.domain.Customer;
import com.mea.ex.cs.domain.CustomerHistory;
import com.mea.ex.cs.repository.CustomerHistoryRepository;
import com.mea.ex.cs.repository.CustomerRepository;
import com.mea.ex.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerEntityListener {

//    @PrePersist
//    @PreUpdate
    @PostPersist
    @PostUpdate
    public void prePostsistAndPostUpdate(Object o){
        CustomerHistoryRepository customerHistoryRepository = BeanUtils.getBean(CustomerHistoryRepository.class);
        CustomerRepository customerRepository = BeanUtils.getBean(CustomerRepository.class);

        Customer customer = (Customer) o;
        CustomerHistory customerHistory = new CustomerHistory();
        customerHistory.setName(customer.getName());
        customerHistory.setEmail(customer.getEmail());
        customerHistory.setRole(customer.getRole());
        customerHistory.setComment(customer.getComment());
        customerHistory.setCustomerId(customer.getId());
        customerHistoryRepository.save(customerHistory);

        customer.addCustomerHistory(customerHistory);
    }
}
