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
public class FindModel {
    private String name;

    public FindModel(String name) {
        this.name = name;
    }

    public FindModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
