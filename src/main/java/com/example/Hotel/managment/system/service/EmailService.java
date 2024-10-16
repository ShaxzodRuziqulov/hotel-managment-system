///**
// * Author: Shaxzod Ro'ziqulov
// * User:Ruzikulov
// * DATE:16.10.2024
// * TIME:12:12
// */
//package com.example.Hotel.managment.system.service;
//
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmailService {
//    private final JavaMailSender mailSender;
//
//    public EmailService(JavaMailSender mailSender) {
//        this.mailSender = mailSender;
//    }
//
//    public void sendVerificationEmail(String to, String link) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject("Email Verification");
//        message.setText("Click the link to verify your email: " + link);
//        mailSender.send(message);
//    }
//}
