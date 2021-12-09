package com.TotalWork.CompleteTraining.controller;

import com.TotalWork.CompleteTraining.exception.ResponseHandler;
import com.TotalWork.CompleteTraining.model.User;
import com.TotalWork.CompleteTraining.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //get all user
    @GetMapping("/user")
    public ResponseEntity<Object> getUsers(){
       List<User> user=userService.getAllUser();

      return ResponseHandler.response(HttpStatus.OK,true,"get all user",user);
    }

    //get single user by id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
       User user= userService.getUserId(id);

       return ResponseHandler.response(HttpStatus.OK,true,"get user is working",user);


    }

    //create new user
    @PostMapping("/user")
    public ResponseEntity<Object> saveUsers(@RequestBody User user){
        User users= userService.saveUser(user);
         return ResponseHandler.response(HttpStatus.OK,true,"create api is working",users);
    }


    //update user by id
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsers(@PathVariable Long id, @RequestBody User user){
       User user1= userService.updateUser(user,id);
        return ResponseHandler.response(HttpStatus.OK,true,"update is working",user1);
    }

    //delete by id
    @DeleteMapping("/{id}")
    public  ResponseEntity<Object> deleteRemove(@PathVariable Long id  ){

         userService.deleteUser(id);
        return ResponseHandler.response(HttpStatus.OK,true,"delete is working");
    }
}