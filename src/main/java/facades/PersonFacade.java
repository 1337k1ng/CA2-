package facades;

import Exceptions.HobbyNotFoundException;
import Exceptions.PersonNotFoundException;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class PersonFacade implements IPersonFacade {

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
    
  
    
    @Override
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

    @Override
    public List<Person> getAllPersonswithSpecifiedHobby(String hobbyName) throws HobbyNotFoundException{
        EntityManager em = emf.createEntityManager();
          List<Person> persons;
       try{
               Hobby hob = em.find(Hobby.class, hobbyName);
                 if (hob == null) {
                   throw new HobbyNotFoundException("Hobby with given name not found");
                 }
               persons = hob.getPersons();
            return persons;
            
        }finally{  
            em.close();
        }
        
    }
    
    
    @Override
    public Person getPersonByID(int id) throws PersonNotFoundException{
        EntityManager em = emf.createEntityManager();
        try{
            
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p where p.id = ?1", Person.class);
            query.setParameter(1, id);
            Person person = query.getSingleResult();
        
            return person;
            
        } catch(NoResultException e){
            throw new PersonNotFoundException("Not found");
       }finally{  
            em.close();
        }
        
    }

    
    @Override
    public Person getPersonByTelephoneNumber(String number) throws PersonNotFoundException{
        EntityManager em = emf.createEntityManager();
        try{
            
             Phone phone = em.find(Phone.class, number);
             
                  if (phone == null){
                  throw new PersonNotFoundException("Not found");
                    }
               
            Person person = phone.getPerson();          
            
            return person;
        }finally{  
            em.close();
        }
        
    }
    
    @Override
    public int getCountOfPersonsWithHobby(String hobbyName) throws HobbyNotFoundException{
        EntityManager em = emf.createEntityManager();
        try{
            
            Hobby hobby = em.find(Hobby.class, hobbyName);
            
            if (hobby == null){
                throw new HobbyNotFoundException("Hobby with given name not found");
            }
            
            int count = hobby.getPersons().size();
           
            return count;
        }finally{  
            em.close();
        }
        
    }

}
