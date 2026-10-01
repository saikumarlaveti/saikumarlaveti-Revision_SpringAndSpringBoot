package com.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Model.OrderRequest;

@Service
public class OrderService {

    @Autowired
    private EmailService emailService;

    public String placeOrder(OrderRequest request) {

        try {

            // In real applications,
            // order would first be saved to database.

            emailService.sendOrderEmail(
                    request.getCustomerEmail(),
                    request.getCustomerName(),
                    request.getProductName(),
                    request.getPrice()
            );

            return "Order placed and email sent successfully";

        } catch (Exception e) {

            e.printStackTrace();

            return "Order placed but email sending failed";
        }
    }
}