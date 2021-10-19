package com.mea.ex.cs.repository;

import com.mea.ex.cs.domain.Company;
import com.mea.ex.cs.domain.Customer;
import com.mea.ex.cs.domain.CustomerRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class CompanyRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CompanyRepository companyRepository;



    @Commit
    @Transactional
    @Test
    void oToM(){

        Company company = Company.builder()
                .name("회사2")
                .build();

        Customer customer = new Customer();
        customer.setName("고객2");
        customer.setRole(CustomerRole.USER);
        customer.setComment("테스트 고객2");
        customerRepository.save(customer);

        company.addCustomer(customer);

        companyRepository.save(company);


        System.out.println("getCustomerHistoryList>>>>"+customer.getCustomerHistoryList());


        System.out.println(company.getCustomerList());
    }

    @Test
    @Transactional(readOnly = true)
    void oToMSearchTest(){
        Company company = companyRepository.getById(5L);
        System.out.println(company);

        Customer customer = customerRepository.getById(5L);
        System.out.println(customer.getCustomerHistoryList());
    }
}