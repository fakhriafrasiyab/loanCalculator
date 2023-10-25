package com.thealiyev.LoanCalculatorRestAPI.model.loan.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class LoanResponse implements Serializable {
    private boolean decision;
    private int loanAmount;
}
