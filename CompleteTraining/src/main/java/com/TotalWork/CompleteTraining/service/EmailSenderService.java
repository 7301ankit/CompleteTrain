package com.TotalWork.CompleteTraining.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void simpleMailSender(String toEmail,String body,String subject){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom("ankit.bainsla@oodles.io");
        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);

        mailSender.send(mailMessage);
        System.out.println("mail send");
    }


}
