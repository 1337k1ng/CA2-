/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
        List<Phone> phones = new ArrayList<Phone>();
        
        phones.add(new Phone("1121dADa3a","Hjemma11edNumamer"));
        Person p = new Person("mai11adla","fiar1dst1a","laa1sdt1a","Airsoft",new Address("ve1a1dj","addi1atido1nale",2700),phones);
        
        try {
        em.getTransaction().begin();    
        em.persist(p);
            
        em.getTransaction().commit();
        } finally {
      
            em.close();
        }
    System.out.println(p.getAddress().getPersons().toString());
    }
    
}
        
        
    

