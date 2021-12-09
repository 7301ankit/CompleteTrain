package com.TotalWork.CompleteTraining.service;

import com.TotalWork.CompleteTraining.model.EmailCustom;
import com.TotalWork.CompleteTraining.repositry.EmailCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailCustomService {

     @Autowired
     private EmailCustomRepository emailCustomRepository;

     //getAll email
     public List<EmailCustom> getAllEmail(){
         return emailCustomRepository.findAll();
     }

     // get by id find data
    public EmailCustom getEmailId(Long id){
         return emailCustomRepository.findById(id).orElse(null);
    }
    //save new user
    public EmailCustom saveEmail(EmailCustom email){
         return emailCustomRepository.save(email);
    }
    //update new user
    public EmailCustom updateEmail(EmailCustom email, Long id){
         EmailCustom email1=emailCustomRepository.findById(id).orElse(null);
         email1.setName(email.getName());
         email1.setEmail(email.getEmail());
         email1.setPassword(email.getPassword());
         email1.setNumber(email.getNumber());
         return emailCustomRepository.save(email1);
    }
    //delete emailby id
    public void deleteEmail(Long id){
         emailCustomRepository.deleteById(id);
    }

}
