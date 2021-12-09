package com.TotalWork.CompleteTraining.model;

import com.TotalWork.CompleteTraining.validation.Email;
import com.TotalWork.CompleteTraining.validation.Number;
import com.TotalWork.CompleteTraining.validation.Password;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "email_custom")
public class EmailCustom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @NotEmpty(message = "email must have a value")
    @Email(message = "email must have follow this format *****@**")
    private String email;

    @NotEmpty
    @Size(message = "password must have  8 charactor")
    @Password
    private String password;

    @NotEmpty
    @Size(min = 10,max = 10,message = "maximum or minimum 10 number")
    @Number
    private String number;

    public EmailCustom(){}

    public EmailCustom(String name, String email, String password, String number) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.number = number;
    }

    public Long getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
