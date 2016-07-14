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
import javax.persistence.ManyToOne;

/**
 *
 * @author fabio
 */
@Entity
public class Purchase implements Serializable {
    @Id
    @GeneratedValue
    private Long ID;
    
    int amount;
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Event event;

    public Purchase() {
    }

    public Purchase(int amount, User user, Event event) {
        this.amount = amount;
        this.user = user;
        this.event = event;
    }
    
    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
