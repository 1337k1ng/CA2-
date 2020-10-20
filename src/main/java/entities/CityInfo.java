/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Benjamin
 */
@Entity
public class CityInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private int zipCode;
    private String city;
    @OneToMany(mappedBy = "cityInfo")
    private List<Address> address;

    public CityInfo() {
    }

    public CityInfo(int zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }

    CityInfo(int zipCode) {
       this.zipCode = zipCode;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
    

   
}
