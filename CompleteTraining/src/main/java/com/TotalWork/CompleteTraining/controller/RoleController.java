package com.TotalWork.CompleteTraining.controller;

import com.TotalWork.CompleteTraining.exception.BusinessException;
import com.TotalWork.CompleteTraining.exception.CustomExceptionHandler;
import com.TotalWork.CompleteTraining.exception.ResponseHandler;
import com.TotalWork.CompleteTraining.model.Role;
import com.TotalWork.CompleteTraining.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    //get all user
    @GetMapping("/role1")
    public ResponseEntity<Object> getALlRoles(){
        List<Role> role=roleService.getAllRole();
         return ResponseHandler.response(HttpStatus.OK,true,"get All role",role);

    }

    //get single user by id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getRoleId(@PathVariable Long id){
      try {
          Role role = roleService.getRoleById(id);
          return ResponseHandler.response(HttpStatus.OK, true, "get single id", role);
      }
      catch (BusinessException ex){
          return ResponseHandler.response(HttpStatus.NOT_FOUND, false, "error message");
      }
    }

    //create new user
    @PostMapping("/role1")
    public ResponseEntity<Object> createRole(@RequestBody Role role){
        Role role1=roleService.saveRole(role);
        return ResponseHandler.response(HttpStatus.OK,true,"create new role",role1);

    }


    //update user by id
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRoles(@PathVariable Long id, @RequestBody Role role){
        Role role1=roleService.updateRole(role,id);
        return ResponseHandler.response(HttpStatus.OK,true,"update details",role1);
    }

    //delete by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
        return  ResponseHandler.response(HttpStatus.OK,true,"delete api complete");
    }
}
