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


    @Test
    void oToM(){
        Company company = Company.builder()
                .name("회사1")
                .build();

        Customer customer = new Customer();
        customer.setName("고객1");
        customer.setRole(CustomerRole.USER);
        customer.setComment("테스트 고객");


        companyRepository.save(company);

        customerRepository.save(customer);
    }
}