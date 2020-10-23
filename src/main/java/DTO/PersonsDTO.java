/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick
 */
public class PersonsDTO {
    
    
    private List<PersonDTO> persons = new ArrayList();
    
    
     public PersonsDTO(){}
    public PersonsDTO(List<Person> ps){
        
        for (Person p : ps){
            this.persons.add(new PersonDTO(p));
        }
        
    }

    public void setPersons(List<PersonDTO> persons) {
        this.persons = persons;
    }

    public List<PersonDTO> getPersons() {
        return persons;
    }
    
    
}
