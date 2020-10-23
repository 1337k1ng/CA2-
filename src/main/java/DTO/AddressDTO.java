/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Address;
import entities.CityInfo;

/**
 *
 * @author Patrick
 */
public class AddressDTO {
    
    private String street;
    private CityInfoDTO cityinfo;
    
    
    
    public AddressDTO(){}
    public AddressDTO(Address a){
        this.street = a.getStreet();
        this.cityinfo = new CityInfoDTO(a.getCityInfo()); 
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public CityInfoDTO getCityinfo() {
        return cityinfo;
    }

 

    @Override
    public String toString() {
        return "AddressDTO{" + "street=" + street + ", cityinfo=" + cityinfo + '}';
    }
    
    
    
}
