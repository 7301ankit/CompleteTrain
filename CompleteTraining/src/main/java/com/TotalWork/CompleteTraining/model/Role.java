package com.TotalWork.CompleteTraining.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.persistence.metamodel.SingularAttribute;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity

@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "role")
    private User user;

    public Role(String name) {
        this.name = name;
    }

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roleSet")
    private Set<User> userSet = new HashSet<>();

    public Role() {

    }

    public Set<User> getUserSet() {

        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Long getId(SingularAttribute<AbstractPersistable, Serializable> id) {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
