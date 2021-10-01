package com.mea.ex.cs.repository;

import com.mea.ex.cs.domain.Customer;
import com.mea.ex.cs.domain.Role;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
//    @Transactional
    void findMethod(){
        //기본 인서트 문
        //기본 인서트 문을 사용한 이유는 data.sql의 사용법을 잘 모르겠어서다.
        //인텔리제이 울티메이트 버전이 아니라서 그런 것 같다.
        basicInsert();

        //정렬 사용
        List<Customer> customers = customerRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));

        customers.forEach(System.out::println);

        // in 조건 절
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        ids.add(4L);
        List<Customer> customers1 = customerRepository.findAllById(ids);

        customers1.forEach(System.out::println);

        // in 조건 절 2

        List<Customer> customers2 = customerRepository.findAllById(Lists.newArrayList(1L, 2L));

        customers2.forEach(System.out::println);

        
        //org.hibernate.LazyInitializationException: could not initialize proxy [com.mea.ex.cs.domain.Customer#1] - no Session
        //오류가 남
//        // 오류가 나지 않기 위해서는 Transactional 필요
//        Customer customer = customerRepository.getOne(5L);
//
//        System.out.println(customer);

        //Optional orElse 사용
        Customer customer = customerRepository.findById(1L).orElse(null);
        System.out.println(customer);

    }

    @Test
    void saveMethod(){
        basicInsert();

        Customer customer1 = Customer.builder()
                .name("guna")
                .comment("USER")
                .email("guna@clc.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .name("puna")
                .comment("USER")
                .email("puna@clc.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        customerRepository.saveAll(Lists.newArrayList(customer1, customer2));

        List<Customer> customers = customerRepository.findAll();

        customers.forEach(System.out::println);


    }

    @Test
    void flushTest(){
        //플러시 테스트
        Customer customer1 = Customer.builder()
                .name("플러시테스트")
                .email("flush@aaa.com")
                .build();

        customerRepository.save(customer1);

        customerRepository.flush();

        customerRepository.findAll().forEach(System.out::println);


        //플러시 테스트2
        Customer customer2 = Customer.builder()
                .name("플러시테스트2")
                .email("saveAllAndFlush@aaa.com")
                .build();

        customerRepository.saveAndFlush(customer2);
        customerRepository.findAll().forEach(System.out::println);
    }

    @Test
    void count(){
        basicInsert();
        long count = customerRepository.count();

        System.out.println(count);

        boolean exists = customerRepository.existsById(1L);

        System.out.println(exists);

    }

    @Test
    void delete(){
        basicInsert();

        customerRepository.delete(customerRepository.findById(1L).orElseThrow(()->new RuntimeException()));
        //customerRepository.delete(customerRepository.findById(1L).orElseThrow(RuntimeException::new));

        customerRepository.deleteById(2L);
        customerRepository.findAll().forEach(System.out::println);

        customerRepository.deleteInBatch(customerRepository.findAllById(Lists.newArrayList(4L,5L)));
        customerRepository.findAll().forEach(System.out::println);

        customerRepository.deleteAllInBatch();
        //customerRepository.deleteAll();
        customerRepository.findAll().forEach(System.out::println);
    }

    @Test
    void page(){
        basicInsert();
        Page<Customer> customers = customerRepository.findAll(PageRequest.of(1,3));

        System.out.println(customers);
        System.out.println("getTotalPages : "+ customers.getTotalPages());
        System.out.println("getTotalElements : "+ customers.getTotalElements());
        System.out.println("getNumberOfElements : "+ customers.getNumberOfElements());
        System.out.println("getSort : "+ customers.getSort());
        System.out.println("getSize : "+ customers.getSize());
    }

    @Test
    void cbe(){
        basicInsert();
        customerRepository.findAll().forEach(System.out::println);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("name")
                .withMatcher("email", endsWith());

        Customer customer = Customer.builder()
                .name("juna")
                .email("cha.com")
                .build();

        Example<Customer> example = Example.of(customer, matcher);
        customerRepository.findAll(example).forEach(System.out::println);

        ExampleMatcher matcher1 = ExampleMatcher.matching()
//                .withIgnorePaths("name")
                .withMatcher("email", endsWith());

        Customer customer1 = Customer.builder()
                .name("juna")
                .email("clc.com")
                .build();
        //Example<Customer> example1 = Example.of(customer1);
        Example<Customer> example1 = Example.of(customer1, matcher1);
        customerRepository.findAll(example1).forEach(System.out::println);


        Customer customer2 = new Customer();
        customer2.setEmail("clc");

        ExampleMatcher matcher2 = ExampleMatcher.matching().withMatcher("email", contains());
        Example<Customer> example2 = Example.of(customer2, matcher2);
        customerRepository.findAll(example2).forEach(System.out::println);
    }

    @Test
    void crud(){
        // 연습
        Customer customer = new Customer();
        customer.setName("테스트1");
        customer.setComment("테스트1 코멘트");
        customer.setEmail("aa@aa.com");
        customer.setCreateAt(LocalDateTime.now());
        customer.setUpdateAt(LocalDateTime.now());

        Customer customer1 = Customer.builder()
                .name("테스트2")
                .comment("테스트2 코멘트")
                .email("bb@bb.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();
        Customer customer2 = Customer.builder()
                .name("테스트3")
                .comment("테스트3 코멘트")
                .email("cc@cc.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        customerRepository.save(customer);
        customerRepository.save(customer1);
        customerRepository.save(customer2);

//        Customer customer = new Customer();
//        customer.setName("테스트1");
//        customer.setComment("테스트1 코멘트");
//        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("의미없다", contains());
//        Example<Customer> example = Example.of(customer, matcher);
//        System.out.println(matcher);
//        System.out.println(example);
//        customerRepository.findAll(example).forEach(System.out::println);
    }

    @Test
    void queryMethod1(){
        
        //쿼리 메소드 연습
        System.out.println("findByName >"+customerRepository.findByName("테스트1"));
        System.out.println("findByEmail >"+customerRepository.findByEmail("aa@aa.com"));
        System.out.println("getByEmail >"+customerRepository.getByEmail("bb@bb.com"));
        System.out.println("readByEmail >"+customerRepository.readByEmail("cc@cc.com"));
        System.out.println("queryByEmail >"+customerRepository.queryByEmail("aa@aa.com"));
        System.out.println("searchByEmail >"+customerRepository.searchByEmail("bb@bb.com"));
        System.out.println("streamByEmail >"+customerRepository.streamByEmail("cc@cc.com"));
//        System.out.println("findCustomerByEmail >"+customerRepository.findCustomerEmail("aa@aa.com"));
        System.out.println("findFirst2ByName >"+customerRepository.findFirst2ByName("테스트2"));
        System.out.println("findTop2ByName >"+customerRepository.findTop2ByName("테스"));
        System.out.println("findLast1ByName >"+customerRepository.findLast1ByName("테"));
    }

    @Test
    void queryMethod2(){
        basicInsert();
        System.out.println("findByEmailAndName ::::: "+customerRepository.findByEmailAndName("juna@clc.com", "auna"));
        System.out.println("findByEmailOrName ::::: "+customerRepository.findByEmailOrName("juna@clc.com", "auna"));
        System.out.println("findByCreateAtAfter :::::: "+customerRepository.findByCreateAtAfter(LocalDateTime.now().minusDays(-1L)));
        System.out.println("findByCreateAtGreaterThan ::::: "+customerRepository.findByCreateAtGreaterThan(LocalDateTime.now().minusDays(-1L)));
        System.out.println("findByIdAfter ::::: "+customerRepository.findByIdAfter(3L));
        System.out.println("findByCreateAtGreaterThanEqual : "+customerRepository.findByCreateAtGreaterThanEqual(LocalDateTime.now().minusDays(-2L)));
        System.out.println("findByCreateAtBetween ::::: "+customerRepository.findByCreateAtBetween(LocalDateTime.now().minusDays(-2L), LocalDateTime.now().plusDays(1L)));
        System.out.println("findByCreateAtBetween ::::: "+customerRepository.findByCreateAtBetween(LocalDateTime.now().minusDays(-2L), LocalDateTime.now().plusDays(1L)));

        System.out.println("findByIdBetween ::::: "+customerRepository.findByIdBetween(2L, 3L));
        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual ::::: "+customerRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));
        System.out.println("findByIdIsNotNull ::::: "+customerRepository.findByIdIsNotNull());

        System.out.println("findByNameIn ::::: "+customerRepository.findByNameIn(Lists.newArrayList("juna", "euna")));
        System.out.println("findByNameStartingWith ::::: "+customerRepository.findByNameStartingWith("na"));
        System.out.println("findByNameEndingWith ::::: "+customerRepository.findByNameEndingWith("na"));
        System.out.println("findByNameContains ::::: "+customerRepository.findByNameContains("na"));
        System.out.println("findByNameLike ::::: "+customerRepository.findByNameLike("na"));

    }

    @Test
    void queryMethod3(){
        basicInsert();

        System.out.println("findTop1ByName ===============?"+ customerRepository.findTop1ByName("juna"));
        System.out.println("findTop2ByName ===============?"+ customerRepository.findTop2ByName("juna"));
        System.out.println("findTopByNameOrderByIdDesc ===============?"+ customerRepository.findTopByNameOrderByIdDesc("juna"));
        System.out.println("findFirstByNameOrderByIdDescEmailAsc ===============?"+ customerRepository.findFirstByNameOrderByIdDescEmailAsc("juna"));
        System.out.println("findFirstByName ===============?"+ customerRepository.findFirstByName("juna", Sort.by(Sort.Order.asc("comment"))));
        System.out.println("findByName ===============?"+ customerRepository.findByName("juna", PageRequest.of(1,2)).getTotalElements());
        System.out.println("findByName ===============?"+ customerRepository.findByName("juna", PageRequest.of(1,2)).getTotalPages());
        System.out.println("findByName ===============?"+ customerRepository.findByName("juna", PageRequest.of(1,2)).getContent());
        System.out.println("findByName ===============?"+ customerRepository.findByName("juna", PageRequest.of(1,2)).getNumberOfElements());
        System.out.println("findByName ===============?"+ customerRepository.findByName("juna", PageRequest.of(1,2).first()));
        System.out.println("findByName ===============?"+ customerRepository.findByName("juna", PageRequest.of(1,2)));
    }

    @Test
    void entityTest(){
        basicInsert();
        Customer customer = customerRepository.findById(3L).orElseThrow(RuntimeException::new);
        customer.setRole(Role.MANAGER);
        customer.setUpdateAt(LocalDateTime.now().plusDays(1L));

        customerRepository.save(customer);
        System.out.println(customer.getRole());


    }

    void basicInsert(){
        Customer customer1 = Customer.builder()
                .name("juna")
                .comment("BOSS")
                .role(Role.BOSS)
                .email("juna@clc.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        Customer customer2 = Customer.builder()
                .name("auna")
                .comment("MANAGER")
                .role(Role.MANAGER)
                .email("auna@clc.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        Customer customer3 = Customer.builder()
                .name("euna")
                .comment("USER")
                .role(Role.USER)
                .email("euna@cha.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        Customer customer4 = Customer.builder()
                .name("buna")
                .comment("USER")
                .role(Role.USER)
                .email("buna@cha.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        Customer customer5 = Customer.builder()
                .name("quna")
                .comment("USER")
                .role(Role.USER)
                .email("quna@clc.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();


        Customer customer6 = Customer.builder()
                .name("juna")
                .comment("USER")
                .role(Role.USER)
                .email("juna@clc.com")
                .createAt(LocalDateTime.now())
                .updateAt(LocalDateTime.now())
                .build();

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);
        customerRepository.save(customer6);

    }
}