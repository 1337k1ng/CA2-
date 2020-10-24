package facades;

import DTO.PersonDTO;
import DTO.CityInfoDTO;
import DTO.PersonDTO;
import DTO.PersonsDTO;
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
    public List<PersonDTO> getAllPersons(){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<PersonDTO> query = em.createQuery("SELECT new DTO.PersonDTO(p) FROM Person p", PersonDTO.class);
          
            List<PersonDTO> persons = query.getResultList();
            return persons;
        }finally{  
            em.close();
        }
        
    }

   
    @Override
    public List<PersonDTO> getAllPersonswithSpecifiedHobby(String hobbyName) throws HobbyNotFoundException{
        EntityManager em = emf.createEntityManager();
       try{
               Hobby hob = em.find(Hobby.class, hobbyName);
               
                 if (hob == null) {
                   throw new HobbyNotFoundException("No hobby found with the provided name");
                 }
                 
           PersonsDTO p = new PersonsDTO(hob.getPersons());
            return p.getPersons();
            
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
    public PersonDTO getPersonByTelephoneNumber(String number) throws PersonNotFoundException{
        EntityManager em = emf.createEntityManager();
        try{
            
             Phone phone = em.find(Phone.class, number);
             
                  if (phone == null){
                  throw new PersonNotFoundException("No person found with the provided ID");
                    }
               
            PersonDTO person = new PersonDTO(phone.getPerson());          
            
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
    

   
    public PersonDTO addNewPerson(Person p) {
    EntityManager em = emf.createEntityManager();
        try{
            
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();

               return new PersonDTO(p);
        }finally{  
            em.close();
        }                   
    }

    
    @Override
    public PersonDTO editPerson(Person p) {
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

               return new PersonDTO(pEdit);
        }finally{  
            em.close();
        }           

    }


    public PersonDTO deletePerson(Long id) throws PersonNotFoundException {
    EntityManager em = emf.createEntityManager();
     
        try{
            
         Person p = em.find(Person.class, id);
         
         if (p == null){
             throw new PersonNotFoundException("No person found with the provided ID");
         }
         
         em.getTransaction().begin();
         em.remove(p);
         em.getTransaction().commit();
        
            return new PersonDTO(p);
        }finally{  
            em.close();
        }
            
      }

    
    
    @Override
    public List<CityInfoDTO> getAllCitys(){
        
         EntityManager em = emf.createEntityManager();
        try{
            
           TypedQuery<CityInfoDTO> tq = em.createQuery("SELECT new DTO.CityInfoDTO(c) FROM CityInfo c", CityInfoDTO.class);

           List<CityInfoDTO> allCitys = tq.getResultList();
           
           if (allCitys.isEmpty()){
           // throw new Exception("An error occurred in retrieving data from the server. Please try again later");
           }
           
               return allCitys;
               
        }finally{  
            em.close();
        }
    }

}
