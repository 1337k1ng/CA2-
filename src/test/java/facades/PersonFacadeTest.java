package facades;

import DTO.PersonDTO;
import Exceptions.HobbyNotFoundException;
import Exceptions.PersonNotFoundException;
import entities.Address;
import entities.CityInfo;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import utils.EMF_Creator;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class PersonFacadeTest {

    private static EntityManagerFactory emf;
    private static PersonFacade facade;
    

     static int id = 1;
    static String phone = "2010211";
    static String firstname = "Hans";
       static String lastname = "Hans";
    public PersonFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = PersonFacade.getFacadeExample(emf);
      EntityManager em = emf.createEntityManager();
      
       Person p = new Person("Hans@Hansen.dk", firstname, lastname);
      Address a = new Address("Njalsgade", "Hjemmeadresse", 2700);
    
      p.addHobby("Taekwondo");
      p.setAddress(a);
      p.addPhone(phone, "Home phone");
    
      
       try {
            em.getTransaction().begin();
                em.createNamedQuery("Person.deleteAllRows").executeUpdate();
                em.persist(new CityInfo(2700,"Glostrup"));
                em.persist(new CityInfo(2800,"Roskilde"));
                em.persist(new Hobby("Taekwondo","Brucelee.com","Badass-sport","Pure-fire"));
            em.getTransaction().commit();
            
            
            em.getTransaction().begin();
                 em.persist(p);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        
    }

    @AfterEach
    public void tearDown() {
       

    }

    @Test
    public void testGetAllPersons() {
        assertEquals(1, facade.getAllPersons().size(), "Expects one rows in the database");
    }
    
    @Test

    public void testGetAllPersonsByHobby() throws HobbyNotFoundException {
        List<PersonDTO> persons = facade.getAllPersonswithSpecifiedHobby("Taekwondo");
        assertEquals(1, persons.size(), "Expects one rows in the database");
    }
    
    @Test
    public void testGetAllPersonsByHobbyNEGATIVE() throws HobbyNotFoundException {
        assertThrows(HobbyNotFoundException.class, () -> {
                facade.getAllPersonswithSpecifiedHobby("wrong hobby name");
          }, "if persons phonenumber not found in DB It should throw PersonNotFoundExcetion");
           

    }
    
     @Test
    public void testGetPersonByID() throws PersonNotFoundException {
        assertEquals("Hans", facade.getPersonByID(1).getFirstName(), "Expects person with id = 1 to have the name Hans");
    }
    
      @Test
    public void testGetPersonByIDNEGATIVE(){
        assertThrows(PersonNotFoundException.class, () -> {
            facade.getPersonByID(100000);
        }, "if persons ID not found in DB It should throw PersonNotFoundExcetion");    
    }
    
    @Test
    public void testgetPersonByTelephoneNumber() throws PersonNotFoundException {
        String name = firstname + " " + lastname;
        assertEquals(name, facade.getPersonByTelephoneNumber(phone).getFullName(), "Expects person with phonenumber = 2010211 to have the name Hans hansen");
    }
  
    
    @Test
    public void testgetPersonByTelephoneNumberNEGATIVE() throws PersonNotFoundException {
        assertThrows(PersonNotFoundException.class, () -> {
                facade.getPersonByTelephoneNumber("wrong phone number");
          }, "if persons phonenumber not found in DB It should throw PersonNotFoundExcetion");
    }
    
    

    @Test
    public void testGetCountOfPersonsWithHobby() throws HobbyNotFoundException {  
         assertEquals(1, facade.getCountOfPersonsWithHobby("Taekwondo"), "Expects one rows in the database");
    }
    
    @Test
    public void testGetCountOfPersonsWithHobbyNEGATIVE() throws PersonNotFoundException {
        assertThrows(HobbyNotFoundException.class, () -> {
                facade.getCountOfPersonsWithHobby("wrong hobby name");
          }, "");
    }
    
}
