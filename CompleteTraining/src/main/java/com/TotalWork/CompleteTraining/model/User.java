package com.TotalWork.CompleteTraining.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //one to one mapping.
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_role")
    private  Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    //one to many mapping
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Role> roles=new ArrayList<>();

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    //many to many mapping
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Many_To_Many")
    private Set<Role> roleSet=new HashSet<>();



    public User(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String address;

    public User(){

    }

    public User(Long id, /*Role role,*/ String firstName, String lastName, String address) {
        this.id = id;
      //  this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
