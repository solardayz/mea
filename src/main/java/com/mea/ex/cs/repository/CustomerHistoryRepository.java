package com.mea.ex.cs.repository;

import com.mea.ex.cs.domain.CustomerHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerHistoryRepository extends JpaRepository<CustomerHistory, Long> {
}
