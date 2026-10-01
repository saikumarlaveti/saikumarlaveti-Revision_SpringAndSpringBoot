package com.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShoppingController {

    private static final Logger logger =
            LoggerFactory.getLogger(ShoppingController.class);

    @Autowired
    public RestTemplate template;

    @GetMapping("/shopping")
    public String shopping() {

        logger.info("Welcome to Shopping Module");

        String response = template.getForObject(
                "http://localhost:9082/billing",
                String.class
        );

        logger.info("Back to shopping module");

        return response;
    }
}