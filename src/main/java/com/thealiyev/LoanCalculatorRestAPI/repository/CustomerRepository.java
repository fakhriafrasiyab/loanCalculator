package com.thealiyev.LoanCalculatorRestAPI.repository;

import com.thealiyev.LoanCalculatorRestAPI.model.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByName(String name);
}
