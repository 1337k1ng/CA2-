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
    
    
        Address a = new Address("Bredgade 12", "Hjemme addresse", 2700);
        Person p = new Person("Erik2@hotmail.com", "Erik2", "Erik");
        p.setId(9L);
        p.addHobby("Airsoft");
        p.addPhone("120202","Hjemma11edNumamer");
        p.setAddress(a);
        try {
        em.getTransaction().begin();    
       // em.persist(p);
            
        em.getTransaction().commit();
        
           em.getTransaction().begin();    
         
            
           
            
         
    
           
        
        em.getTransaction().commit();
        

         PersonFacade pf = PersonFacade.getFacadeExample(emf);
            System.out.println(pf.getAllPersons().toString());
   
        } finally {
      
            em.close();
        }
 
    }
    
}
        
        
    

