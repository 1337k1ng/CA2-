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
    private List<PhoneDTO> phoneNumbers = new ArrayList();
    private List<HobbyDTO> hobby = new ArrayList();
    private AddressDTO address;

    public PersonDTO(Person p) {
        this.fullName = p.getFirstName() +" "+ p.getLastName();
        this.email = p.getEmail();
        this.phoneNumbers = (new PhonesDTO(p.getPhoneNumbers())).getPhoneDTOS();
        this.address = new AddressDTO(p.getAddress());
        this.hobby = (new HobbysDTO(p.getHobby())).getHobbys();
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

    public List<PhoneDTO> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneDTO> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<HobbyDTO> getHobby() {
        return hobby;
    }

    public void setHobby(List<HobbyDTO> hobby) {
        this.hobby = hobby;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "fullName=" + fullName + ", email=" + email + ", phoneNumbers=" + phoneNumbers + ", hobby=" + hobby + ", address=" + address + '}';
    }
    
    
}
