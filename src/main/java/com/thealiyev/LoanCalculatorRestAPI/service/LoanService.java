package com.thealiyev.LoanCalculatorRestAPI.service;

import com.thealiyev.LoanCalculatorRestAPI.model.loan.request.LoanRequest;
import com.thealiyev.LoanCalculatorRestAPI.model.loan.response.LoanResponse;
import org.springframework.http.ResponseEntity;

public interface LoanService {
    ResponseEntity<LoanResponse> request(LoanRequest loanRequest);

    ResponseEntity<LoanResponse> calculateMaximumSum(LoanResponse loanResponse, int creditModifier, int loanPeriod);

    ResponseEntity<LoanResponse> calculateSuitablePeriod(LoanResponse loanResponse, int creditModifier);
}
