/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uff.dw.model;

/**
 *
 * @author fabio
 */
public class BuyModel {
    private String name;
    private String number;
    private String validate;
    private String code;
    private String title;
    private String eventID;
    public BuyModel() {
    }

    public BuyModel(String title, String eventID) {
        this.title = title;
        this.eventID = eventID;
    }

    public BuyModel(String name, String number, String validate, String code, String title, String eventID) {
        this.name = name;
        this.number = number;
        this.validate = validate;
        this.code = code;
        this.title = title;
        this.eventID = eventID;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }
    
    
}
