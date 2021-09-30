package com.mea.ex.cs.repository;

import com.mea.ex.cs.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
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

    //쿼리 메소드 2

    List<Customer> findByEmailAndName(String email, String name);

    List<Customer> findByEmailOrName(String email, String name);

    List<Customer> findByCreateAtAfter(LocalDateTime yesterday);

    List<Customer> findByIdAfter(Long id);

    List<Customer> findByCreateAtGreaterThan(LocalDateTime yesterday);

    List<Customer> findByCreateAtGreaterThanEqual(LocalDateTime yesterday);

    List<Customer> findByCreateAtBetween(LocalDateTime yesterday, LocalDateTime tomorrow);

    List<Customer> findByIdBetween(Long id1, Long id2);

    List<Customer> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1, Long id2);

    List<Customer> findByIdIsNotNull();

//    List<User> findByAddressIsNotEmpty();   // name is not null and name != '' ??

    List<Customer> findByNameIn(List<String> names);

    List<Customer> findByNameStartingWith(String name);

    List<Customer> findByNameEndingWith(String name);

    List<Customer> findByNameContains(String name);

    List<Customer> findByNameLike(String name);


    //쿼리 메소드 3

    List<Customer> findTop1ByName(String name);

    List<Customer> findTopByNameOrderByIdDesc(String name);

    List<Customer> findFirstByNameOrderByIdDescEmailAsc(String name);

    List<Customer> findFirstByName(String name, Sort sort);

    Page<Customer> findByName(String name, Pageable pageable);
}
