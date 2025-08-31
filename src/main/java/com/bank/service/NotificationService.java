package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendTransactionEmail(String to, String subject, String messageBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(messageBody);
        message.setFrom("your-email@gmail.com"); // sender email
        mailSender.send(message);
    }
}
