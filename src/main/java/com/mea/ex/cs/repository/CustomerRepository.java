package com.mea.ex.cs.repository;

import com.mea.ex.cs.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Set<Customer> findByName(String name);

    Customer findByEmail(String email);

    Customer getByEmail(String email);

    Customer readByEmail(String email);

    Customer queryByEmail(String email);

    Customer searchByEmail(String email);

    Customer streamByEmail(String email);

//    Customer findCustomerEmail(String email);

    Customer findSomethingByEmail(String email);

    List<Customer> findFirst2ByName(String name);

    List<Customer> findTop2ByName(String name);

    List<Customer> findLast1ByName(String name);
}
