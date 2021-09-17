package com.mea.ex.cs.repository;

import com.mea.ex.cs.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
