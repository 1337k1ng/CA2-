package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


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
    private List<Hobby> hobby;
    
    @ManyToOne
    private Address address;
    
    @OneToMany(mappedBy = "person")
    private HashSet<Phone> phoneNumbers;
    
    public Person() {
    }
        
  

   
}
