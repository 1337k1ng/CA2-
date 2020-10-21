/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
    
    public static void main(String[] args) {
        //Create emf pointing to the dev-database
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
    
    
        Address a = new Address("Bredgade 122", "Hjemme addresse", 2700);
        Person p = new Person("Hans@hotmai.com", "Hans", "Hansen");
        p.addHobby("Airsoft");
        p.addPhone("122222","Hjemma11edNumamer");
        p.setAddress(a);
        try {
        em.getTransaction().begin();    
       // em.persist(p);
            
        em.getTransaction().commit();
        
           em.getTransaction().begin();    
            Person pers = em.find(Person.class, 3L);
            System.out.println(pers.getAddress().getCityInfo().getCity());
            System.out.println(pers.getHobby().get(0).getWikiLink());
             
            PersonFacade pf = PersonFacade.getFacadeExample(emf);
           List<Person> ppp = pf.getAllPersonswithSpecifiedHobby("Airsoft");
            
           
                Hobby hob = em.find(Hobby.class, "Airsoft");
                System.out.println(hob.getCategory());
                System.out.println(hob.getPersons().size());
        em.getTransaction().commit();
        } finally {
      
            em.close();
        }
 
    }
    
}
        
        
    

