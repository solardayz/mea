package com.mea.ex.cs.repository;

import com.mea.ex.cs.domain.CustomerHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerHistoryRepository extends JpaRepository<CustomerHistory, Long> {

//    List<CustomerHistory> findByUserId(Long id);
    List<CustomerHistory> findByCustomerId(Long id);

    List<CustomerHistory> findByComment(String comment);
}
