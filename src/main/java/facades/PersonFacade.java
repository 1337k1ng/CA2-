package facades;

import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class PersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private PersonFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
  
    public List<Person> getAllPersons(){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p", Person.class);
            List<Person> persons = query.getResultList();
            return persons;
        }finally{  
            em.close();
        }
        
    }

    public List<Person> getAllPersonswithSpecifiedHobby(String hobbyName){
        EntityManager em = emf.createEntityManager();
        try{
            
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p where ?1 MEMBE", Person.class);
            query.setParameter(1, hobbyName);
            List<Person> persons = query.getResultList();
            return persons;
        }finally{  
            em.close();
        }
        
    }
    
    
    public Person getPersonByID(int id){
        EntityManager em = emf.createEntityManager();
        try{
            
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p where p.id = ?1", Person.class);
            query.setParameter(1, id);
            Person person = query.getSingleResult();
            return person;
        }finally{  
            em.close();
        }
        
    }

    
    public Person getPersonByTelephoneNumber(String number){
        EntityManager em = emf.createEntityManager();
        try{
            
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p where p.phoneNumbers.number = ?1", Person.class);
            query.setParameter(1, number);
            Person person = query.getSingleResult();
            return person;
        }finally{  
            em.close();
        }
        
    }
    
    public int getCountOfPersonsWithHobby(String hobbyName){
        EntityManager em = emf.createEntityManager();
        try{
            
            TypedQuery<Person> query = em.createQuery("SELECT COUNT(p) FROM Person p where p.hobby.name = ?1", Person.class);
            query.setParameter(1, hobbyName);
            List<Person> persons = query.getResultList();
            return persons.size();
        }finally{  
            em.close();
        }
        
    }

}
