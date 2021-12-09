package com.TotalWork.CompleteTraining.service;

import com.TotalWork.CompleteTraining.model.User;
import com.TotalWork.CompleteTraining.repositry.UserRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepositry userRepositry;

    //get all user
    public List<User> getAllUser(){
        return userRepositry.findAll();
    }
    //get by id
    public User getUserId(Long id){
        return userRepositry.findById(id).orElse(null);
    }
    //save user
    public User saveUser(User user){
        return userRepositry.save(user);
    }
    //update user by id
    public User updateUser(User user,Long id){
        User user1=userRepositry.findById(id).orElse(null);
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setAddress(user.getAddress());
        return userRepositry.save(user1);
    }
    // delete user by id
    public void deleteUser(Long id){
        userRepositry.deleteById(id);
        //return "delete user :"+id;
    }
}
