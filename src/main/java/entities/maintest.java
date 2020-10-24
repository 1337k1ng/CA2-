/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import Exceptions.HobbyNotFoundException;
import Exceptions.PersonNotFoundException;
import facades.PersonFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * @author Benjamin
 */
public class maintest {
    
    public static void main(String[] args) throws HobbyNotFoundException, PersonNotFoundException {
        //Create emf pointing to the dev-database
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
    
    
        Address a = new Address("Sydholmsvej 12", "Hjemme addresse", 2700);
        Person p = new Person("Ulla@hotmail.com", "Eriku", "Erik");
        p.setId(9L);
        p.addHobby("Airsoft");
        p.addPhone("1201111202","Hjemma11edNumamer");
        p.setAddress(a);
        try {
        
           
            

        

         PersonFacade pf = PersonFacade.getFacadeExample(emf);
         Person p2 = pf.getPersonByID(9);
         p.setEmail("Edditted");
         pf.editPerson(p2);
        } finally {
      
            em.close();
        }
 
    }
    
}
        
        
    

