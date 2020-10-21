package facades;

import entities.Hobby;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class HobbyFacade implements IHobbyFacade {

    private static HobbyFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private HobbyFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static HobbyFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HobbyFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Hobby getHobby(String hobbyName){
       EntityManager em = emf.createEntityManager();
        try{ 
            Hobby hobby = em.find(Hobby.class,hobbyName);
            System.out.println(hobby.getName());
            return hobby;
        }finally{  
            em.close();
        }
        
        
    }
  

}
