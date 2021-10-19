package com.mea.ex.cs.repository;

import com.mea.ex.cs.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
