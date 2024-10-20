/**
 * Author: Shaxzod Ro'ziqulov
 * User:Ruzikulov
 * DATE:20.10.2024
 * TIME:12:08
 */
package com.example.Hotel.managment.system.service;

import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;


    public void sendEmail(EmailDetails emailDetails){
        try {
            SimpleMailMessage mailMsg = new SimpleMailMessage();
            mailMsg.setFrom(emailSender);
            mailMsg.setTo(emailDetails.getRecipient());
            mailMsg.setText(emailDetails.getMessageBody());
            mailMsg.setSubject(emailDetails.getSubject());
            javaMailSender.send(mailMsg);
            log.info("Mail sent successfully");
        }catch (MailException exception){
            log.debug("Failure occurred while sending email");
        }
    }
}
