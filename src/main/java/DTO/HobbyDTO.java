/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Hobby;

/**
 *
 * @author Patrick
 */
public class HobbyDTO {
    
    
    private String name;
    private String category;
    private String type;
    
    
     public HobbyDTO(){}
     
    public HobbyDTO(Hobby h){
        this.name = h.getName();
        this.category = h.getCategory();
        this.type = h.getType();        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "HobbyDTO{" + "name=" + name + ", category=" + category + ", type=" + type + '}';
    }
    
    
}
