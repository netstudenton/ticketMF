/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.dw.model;

import br.uff.dw.Constant;
import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author fabio
 */
@Entity
public class Event implements Serializable {

    @Id
    @GeneratedValue
    private Long ID;
    private String title;
    private String description;
    private String image;
    private String type;
    private Double price;
    private String place;
    private Integer amount;
 

    public Event() {
    }
    
    public Event(String title, String description, String image, String type, Double price, String local, Integer amount) {
        this.title = title;
        this.description = description;
        this.image = Constant.IMGPATH + image;
        this.type = type;
        this.price = price;
        this.place = local;
        this.amount = amount;
    }
    

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        image = Constant.IMGPATH + image;
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    
}
