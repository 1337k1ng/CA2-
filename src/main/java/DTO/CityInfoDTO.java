/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.CityInfo;

/**
 *
 * @author Patrick
 */
public class CityInfoDTO {
    
    
    
     private int zipCode;
    private String city;
    
    public CityInfoDTO(CityInfo cit){
        this.city = cit.getCity();
        this.zipCode = cit.getZipCode();
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "CityInfoDTO{" + "zipCode=" + zipCode + ", city=" + city + '}';
    }
    
    
    
}
