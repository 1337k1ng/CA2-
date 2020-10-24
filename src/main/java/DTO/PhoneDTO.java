/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Phone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick
 */
public class PhoneDTO {
    
    
      private String number;
    private String description;
    
    
    
    public PhoneDTO(){}
    public PhoneDTO(Phone p){
        this.number = p.getNumber();
        this.description = p.getDescription();
    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "PhoneDTO{" + "number=" + number + ", description=" + description + '}';
    }
    
   
       
    
}
