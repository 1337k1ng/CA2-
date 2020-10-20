package entities;

import facades.HobbyFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;
import utils.EMF_Creator;


@Entity
@NamedQuery(name = "Person.deleteAllRows", query = "DELETE from Person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    
    @ManyToMany
    private List<Hobby> hobby = new ArrayList();
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;
    
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval=true)
    private List<Phone> phoneNumbers;
    
    public Person() {
    }

    public Person(String email, String firstName, String lastName, String hobbyName, Address address, List<Phone> phoneNumbers) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        setHobby(hobbyName);
        setAddress(address);
        setPhoneNumbers(phoneNumbers);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Hobby> getHobby() {
        return hobby;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if (address != null){
          this.address = address;
         address.addPerson(this);
         } 
    }

    public List<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Phone> phoneNumbers) {
      if (phoneNumbers != null){
          this.phoneNumbers = phoneNumbers;
          phoneNumbers.forEach((phone) -> phone.setPerson(this));
         } 
    }
        
  
       public void setHobby(String hobbyName) {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");    
       HobbyFacade hobbyFacade = HobbyFacade.getFacadeExample(emf);
       
       this.hobby.add(hobbyFacade.getHobby(hobbyName));
    }
   
}
