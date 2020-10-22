/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Address;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public class PersonDTO {
    private String fullName;
    private String email;
    private List<Phone> phoneNumbers;
    private List<Hobby> hobby = new ArrayList();
    private Address address;

    public PersonDTO(Person p) {
        this.fullName = p.getFirstName() +" "+ p.getLastName();
        this.email = p.getEmail();
        this.phoneNumbers = p.getPhoneNumbers();
        this.address = p.getAddress();
        this.hobby = p.getHobby();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Phone> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Hobby> getHobby() {
        return hobby;
    }

    public void setHobby(List<Hobby> hobby) {
        this.hobby = hobby;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "fullName=" + fullName + ", email=" + email + ", phoneNumbers=" + phoneNumbers + ", hobby=" + hobby + ", address=" + address + '}';
    }
    
    
}
