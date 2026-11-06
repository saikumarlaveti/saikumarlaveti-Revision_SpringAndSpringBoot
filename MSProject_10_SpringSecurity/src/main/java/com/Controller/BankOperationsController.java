package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankOperationsController {

    @GetMapping("/home")
    public String showHome() {
        return "Welcome to XYZ Bank";
    }

    @GetMapping("/offers")
    public String showOffers() {
        return "Home Loan: 7%, Personal Loan: 12%";
    }

    @GetMapping("/balance")
    public String checkBalance() {
        return "Your balance is ₹50,000";
    }

    @GetMapping("/loanApprove")
    public String approveLoan() {
        return "Loan approved by the manager";
    }
   
}