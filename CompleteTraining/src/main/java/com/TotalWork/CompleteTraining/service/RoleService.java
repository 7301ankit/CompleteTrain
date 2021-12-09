package com.TotalWork.CompleteTraining.service;

import com.TotalWork.CompleteTraining.model.Role;
import com.TotalWork.CompleteTraining.repositry.RoleRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepositry roleRepositry;

    // save role
    public Role saveRole(Role role){
        return roleRepositry.save(role);
    }

    //get all user
    public List<Role> getAllRole(){
        return roleRepositry.findAll();
    }
    // get by id
    public Role getRoleById(Long id){
        return roleRepositry.findById(id).orElse(null);
    }
    public Role updateRole(Role role, Long id){
        Role role1=roleRepositry.findById(id).orElse(null);
        role1.setName(role.getName());
        return  roleRepositry.save(role1);

    }

    public String deleteRole(Long id){
        roleRepositry.deleteById(id);
        return "role delete : "+id;
    }

}
