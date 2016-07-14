/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.dw.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author fabio
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long ID;

    private String name;
    private String cpf;
    private String email;
    private String username;
    private String password;
    public User() {
    }

    public User(String nome, String cpf, String email) {
        this.name = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public User(String nome, String cpf, String email, String username, String password) {
        this.name = nome;
        this.cpf = cpf;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
