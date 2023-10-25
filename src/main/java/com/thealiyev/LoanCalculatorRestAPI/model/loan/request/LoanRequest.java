package com.thealiyev.LoanCalculatorRestAPI.model.loan.request;

import com.thealiyev.LoanCalculatorRestAPI.model.entity.Customer;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class LoanRequest implements Serializable {
    private Customer customer;
    private int loanAmount;
    private int loanPeriod;
}