package com.thealiyev.LoanCalculatorRestAPI.controller;

import com.thealiyev.LoanCalculatorRestAPI.model.loan.request.LoanRequest;
import com.thealiyev.LoanCalculatorRestAPI.model.loan.response.LoanResponse;
import com.thealiyev.LoanCalculatorRestAPI.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loan")
@CrossOrigin("*")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping("/request")
    public ResponseEntity<LoanResponse> request(@RequestBody LoanRequest loanRequest) {
        return loanService.request(loanRequest);
    }
}
