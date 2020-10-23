/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;


import DTO.PersonDTO;
import Exceptions.HobbyNotFoundException;
import Exceptions.PersonNotFoundException;
import entities.CityInfo;
import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public interface IPersonFacade {
        
  
    public List<Person> getAllPersons();
    public List<Person> getAllPersonswithSpecifiedHobby(String hobbyName) throws HobbyNotFoundException;
    public int getCountOfPersonsWithHobby(String hobbyName) throws HobbyNotFoundException;
    public Person getPersonByTelephoneNumber(String number) throws PersonNotFoundException;
    public Person getPersonByID(int id) throws PersonNotFoundException;
    public Person addNewPerson(Person p); 
    public Person editPerson(Person p);
    public Person deletePerson(Long id) throws PersonNotFoundException;
    public List<CityInfo> getAllCitys();

   }



