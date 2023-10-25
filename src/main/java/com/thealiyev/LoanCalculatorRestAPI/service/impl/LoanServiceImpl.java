package com.thealiyev.LoanCalculatorRestAPI.service.impl;

import com.thealiyev.LoanCalculatorRestAPI.model.entity.Customer;
import com.thealiyev.LoanCalculatorRestAPI.model.loan.request.LoanRequest;
import com.thealiyev.LoanCalculatorRestAPI.model.loan.response.LoanResponse;
import com.thealiyev.LoanCalculatorRestAPI.repository.CustomerRepository;
import com.thealiyev.LoanCalculatorRestAPI.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ResponseEntity<LoanResponse> request(LoanRequest loanRequest) {
        Customer customer = customerRepository.findByName(loanRequest.getCustomer().getName());
        int hasDebt = customer.getHasDebt();
        int creditModifier = customer.getCreditModifier();
        int loanPeriod = loanRequest.getLoanPeriod();
        int loanAmount = loanRequest.getLoanAmount();
        LoanResponse loanResponse = new LoanResponse();

        if (hasDebt == 1) {
            return new ResponseEntity<>(loanResponse, HttpStatus.FORBIDDEN);
        } else {
            if (loanAmount < 2000) {
                loanResponse.setDecision(false);
                return new ResponseEntity<>(loanResponse, HttpStatus.FORBIDDEN);
            } else if (loanAmount > 10000) {
                loanResponse.setDecision(false);
                return new ResponseEntity<>(loanResponse, HttpStatus.FORBIDDEN);
            } else {
                if (loanPeriod < 12) {
                    loanResponse.setDecision(false);
                    return new ResponseEntity<>(loanResponse, HttpStatus.FORBIDDEN);
                } else if (loanPeriod > 60) {
                    loanResponse.setDecision(false);
                    return new ResponseEntity<>(loanResponse, HttpStatus.FORBIDDEN);
                } else {
                    return calculateMaximumSum(loanResponse, creditModifier, loanPeriod);
                }
            }
        }
    }

    @Override
    public ResponseEntity<LoanResponse> calculateMaximumSum(LoanResponse loanResponse, int creditModifier, int loanPeriod) {
        int maximumSum = loanPeriod * creditModifier;

        if (maximumSum < 2000) {
            return calculateSuitablePeriod(loanResponse, creditModifier);
        } else {
            loanResponse.setDecision(true);
            loanResponse.setLoanAmount(Math.min(maximumSum, 10000));
            return new ResponseEntity<>(loanResponse, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<LoanResponse> calculateSuitablePeriod(LoanResponse loanResponse, int creditModifier) {
        int loanPeriod = 2000 / creditModifier;

        if (loanPeriod > 60) {
            loanResponse.setDecision(false);
            return new ResponseEntity<>(loanResponse, HttpStatus.FORBIDDEN);
        } else {
            loanResponse.setDecision(true);
            loanResponse.setLoanAmount(2000);
            return new ResponseEntity<>(loanResponse, HttpStatus.OK);
        }
    }
}