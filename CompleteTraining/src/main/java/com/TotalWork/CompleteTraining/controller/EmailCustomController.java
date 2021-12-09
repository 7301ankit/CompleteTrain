package com.TotalWork.CompleteTraining.controller;

import com.TotalWork.CompleteTraining.exception.ResponseHandler;
import com.TotalWork.CompleteTraining.model.EmailCustom;
import com.TotalWork.CompleteTraining.service.EmailCustomService;
import com.TotalWork.CompleteTraining.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/custom")
public class EmailCustomController {

    @Autowired
    private EmailCustomService emailCustomService;

    @Autowired
    private EmailSenderService service;

    //get all custom
    @GetMapping("/email")
    public ResponseEntity<Object> getAllEmails() {
       List<EmailCustom> emailCustoms = emailCustomService.getAllEmail();

      return ResponseHandler.response(HttpStatus.OK,true,"get all email list",emailCustoms);
    }

    //get single user by id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id) {
        EmailCustom emailCustom = emailCustomService.getEmailId(id);
        return ResponseHandler.response(HttpStatus.OK,true,"get by id ",emailCustom);

    }
    //is good

    //create new user
    @PostMapping("/email")
    public ResponseEntity<Object> createUser(@RequestBody EmailCustom emailCustom) {

        EmailCustom emailCustom1= emailCustomService.saveEmail(emailCustom);
        return ResponseHandler.response(HttpStatus.OK,true,"create api is working", emailCustom1);
    }


    //update user by id
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmails(@PathVariable Long id, @RequestBody EmailCustom emailCustom) {
        EmailCustom emailCustom1= emailCustomService.updateEmail(emailCustom,id);
        return ResponseHandler.response(HttpStatus.OK,true,"update api is working", emailCustom1);
    }

    //delete by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteEmail(@PathVariable Long id, EmailCustom emailCustom) {
         emailCustomService.deleteEmail(id);
        return ResponseHandler.response(HttpStatus.OK,true,"delete api is working", emailCustom);
    }

    @PostMapping("/")
    public String sendEmail(){
        try {
            service.simpleMailSender("ankitbainsla.bainsla@gmail.com",
                    "this is body",
                    "this is subject");
            System.out.println("hi");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "email send done";
    }
}

