package facades;

import Exceptions.HobbyNotFoundException;
import Exceptions.PersonNotFoundException;
import entities.CityInfo;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.sql.rowset.serial.SerialException;

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
                   throw new HobbyNotFoundException("No hobby found with the provided name");
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
            throw new PersonNotFoundException("No person found with the provided ID");
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
                  throw new PersonNotFoundException("No person found with the provided ID");
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
                throw new HobbyNotFoundException("No hobby found with the provided name");
            }
            
            int count = hobby.getPersons().size();
           
            return count;
        }finally{  
            em.close();
        }
        
    }
    
       public List<Person> getAllPersonsByHobby(String hobby) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Person p JOIN p.hobbies hobbies WHERE hobbies.name = :hobby");
            query.setParameter("hobby", hobby);
            List<Person> personList = query.getResultList();

            return  personList;
        } finally {
            em.close();
        }

    }

    @Override
    public Person addNewPerson(Person p) {
    EntityManager em = emf.createEntityManager();
        try{
            
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();

               return p;
        }finally{  
            em.close();
        }                   
    }

    @Override
    public Person editPerson(Person p) {
      EntityManager em = emf.createEntityManager();
        try{
          Person pEdit = em.find(Person.class, p.getId());
       
          
          pEdit.setEmail(p.getEmail());
          pEdit.setAddress(p.getAddress());
          pEdit.setFirstName(p.getFirstName());
          pEdit.setLastName(p.getLastName());
          pEdit.setPhoneNumbers(p.getPhoneNumbers());
          
          for (Hobby h : pEdit.getHobby()){
          pEdit.addHobby(h.getName());
          }
          
            em.getTransaction().begin();
            em.persist(pEdit);
            em.getTransaction().commit();

               return p;
        }finally{  
            em.close();
        }           

    }

    @Override
    public Person deletePerson(Long id) throws PersonNotFoundException {
    EntityManager em = emf.createEntityManager();
     
        try{
            
         Person p = em.find(Person.class, id);
         
         if (p == null){
             throw new PersonNotFoundException("No person found with the provided ID");
         }
         
         em.getTransaction().begin();
         em.remove(p);
         em.getTransaction().commit();
        
            return p;
        }finally{  
            em.close();
        }
            
      }

    
    @Override
    public List<CityInfo> getAllCitys(){
        
         EntityManager em = emf.createEntityManager();
        try{
            
           TypedQuery<CityInfo> tq = em.createQuery("SELECT c FROM CityInfo c", CityInfo.class);

           List<CityInfo> allCitys = tq.getResultList();
           
           if (allCitys.isEmpty()){
           // throw new Exception("An error occurred in retrieving data from the server. Please try again later");
           }
           
               return allCitys;
               
        }finally{  
            em.close();
        }
    }

}
