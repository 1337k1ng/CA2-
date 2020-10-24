/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;


import DTO.CityInfoDTO;
import DTO.PersonDTO;
import Exceptions.DBException;
import Exceptions.HobbyNotFoundException;
import Exceptions.PersonNotFoundException;
import entities.Person;
import java.util.List;


public interface IPersonFacade {
        
  
    public List<PersonDTO> getAllPersons();
    public List<PersonDTO> getAllPersonswithSpecifiedHobby(String hobbyName) throws HobbyNotFoundException;
    public int getCountOfPersonsWithHobby(String hobbyName) throws HobbyNotFoundException;
    public PersonDTO getPersonByTelephoneNumber(String number) throws PersonNotFoundException;
    public Person getPersonByID(int id) throws PersonNotFoundException;
    public PersonDTO addNewPerson(Person p); 
    public PersonDTO editPerson(Person p) throws PersonNotFoundException;;
    public PersonDTO deletePerson(Long id) throws PersonNotFoundException;
    public List<CityInfoDTO> getAllCitys() throws DBException;

   }



