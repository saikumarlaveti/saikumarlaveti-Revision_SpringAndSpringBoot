
package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankOperationsController {

    // Login page
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    // Home page
    @GetMapping({"/", "/home"})
    public String showHome() {
        return "home";
    }

    // Offers page
    @GetMapping("/offers")
    public String showOffers() {
        return "offers";
    }

    // Balance page
    @GetMapping("/balance")
    public String checkBalance() {
        return "show_balance";
    }

    // Loan approval page
    @GetMapping("/loanApprove")
    public String approveLoan() {
        return "loan";
    }

    // Access denied page
    @GetMapping("/denied")
    public String accessDenied() {
        return "access_denied";
    }
}
