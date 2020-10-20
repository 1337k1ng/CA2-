package facades;

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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class PersonFacadeTest {

    private static EntityManagerFactory emf;
    private static PersonFacade facade;

    public PersonFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = PersonFacade.getFacadeExample(emf);
      EntityManager em = emf.createEntityManager();
       try {
            em.getTransaction().begin();
            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
            em.persist(new CityInfo(2700,"Glostrup"));
            em.persist(new CityInfo(2800,"Roskilde"));
            em.persist(new Hobby("Taekwondo","Brucelee.com","Badass-sport","Pure-fire"));
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
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            List<Phone> phones1 = new ArrayList();
              phones1.add(new Phone("40404040","Fastnet-nr"));
              Person p = new Person("Hans@mail.dk","Hans","Hansen","Taekwondo",new Address("Vejenvej 21","HjemmeAdresse",2700),phones1);
             em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
             em.remove(em.find(Phone.class,"40404040"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    @Test
    public void testGetAllPersons() {
        assertEquals(1, facade.getAllPersons().size(), "Expects one rows in the database");
    }
    
    @Test
    public void testGetAllPersonsByHobby() {
        assertEquals(1, facade.getAllPersonswithSpecifiedHobby("Taekwondo").size(), "Expects one rows in the database");
    }
    

}
