package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailService {
	@Autowired
    private JavaMailSender mailSender;

    public void sendOrderEmail(
            String to,
            String customerName,
            String productName,
            double price) throws Exception {

        // 1. Create MimeMessage
        MimeMessage message = mailSender.createMimeMessage();

        // 2. Create MimeMessageHelper
        MimeMessageHelper helper =
                new MimeMessageHelper(message, true);

        // 3. From
        helper.setFrom("saikumarlaveti1431@gmail.com");

        // 4. To
        helper.setTo(to);

        // 5. Subject
        helper.setSubject("Order Confirmation");

        // 6. Email body
        String htmlBody =
                "<html>" +
                "<body>" +

                "<h2>Order Confirmation</h2>" +

                "<p>Hello <b>" + customerName + "</b>,</p>" +

                "<p>Your order has been placed successfully.</p>" +

                "<table border='1' cellpadding='10'>" +
                "<tr>" +
                "<th>Product</th>" +
                "<th>Price</th>" +
                "</tr>" +

                "<tr>" +
                "<td>" + productName + "</td>" +
                "<td>₹" + price + "</td>" +
                "</tr>" +

                "</table>" +

                "<br>" +

                "<p>Thank you for your order.</p>" +

                "</body>" +
                "</html>";

        // 7. true means HTML content
        helper.setText(htmlBody, true);

        // 8. Send email
        mailSender.send(message);
    }
}
