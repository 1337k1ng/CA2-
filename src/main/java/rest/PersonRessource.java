package rest;

import DTO.PersonDTO;
import Exceptions.DBException;
import Exceptions.PersonNotFoundException;
import Exceptions.HobbyNotFoundException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Hobby;
import entities.Person;
import utils.EMF_Creator;
import facades.PersonFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("persons")
public class PersonRessource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final PersonFacade FACADE =  PersonFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    // all persons
    
    // VIRKER
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAll() {
        return GSON.toJson(FACADE.getAllPersons());

}   
    //Virker
    ///api/persons/hobby/{hobbyName}/count
    @GET
    @Path("hobby/{hobbyName}/count")
    @Produces({MediaType.APPLICATION_JSON})
    public String hobbyCount(@PathParam("hobbyName")String hobby) throws HobbyNotFoundException {
        return GSON.toJson(FACADE.getCountOfPersonsWithHobby(hobby));

}
    
    // Virker
    @GET
    @Path("id/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getPersonById(@PathParam("id")int id) throws PersonNotFoundException {
        
        
        
        return GSON.toJson(new PersonDTO(FACADE.getPersonByID(id)));
                
        
    }
    
    
     //Virker
    
    @GET
    @Path("number/{number}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getPersonByPhonenumber(@PathParam("number")String number) throws PersonNotFoundException {
        
        return GSON.toJson(FACADE.getPersonByTelephoneNumber(number));
    }
   
        
    // VIRKER
    //All Persons having a specified hobby
    @GET
    @Path("hobby/{hobbyName}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getPersonsWithHobby(@PathParam("hobbyName")String hobby) throws HobbyNotFoundException {
          
     return GSON.toJson(FACADE.getAllPersonswithSpecifiedHobby(hobby));
   
    }
    
    
    
    
    
   
    
    
//  Virker
    @GET
    @Path("zip")
    @Produces({MediaType.APPLICATION_JSON})
    
    public String returnNumberOfCities()throws DBException{
        return GSON.toJson(FACADE.getAllCitys());
       
    }
   
    
    // Lige lavet, virker lortet?
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public String addPerson(String person) {
        Person personToAdd = GSON.fromJson(person, Person.class);
        FACADE.addNewPerson(personToAdd);
        return person;
    }
    
    

    
    
    //Edit person chosen by ID er ikke lavet 
    //Metode mock-uppen tager imod en (int id) lige nu, men deletePersonById tager imod en Long?


    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})  
    public String editPerson(Person p) throws PersonNotFoundException {
        return GSON.toJson(FACADE.editPerson(p));
    }
   
    
    
    


 
    @Path("delete/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    
    public void deletePersonById(@PathParam("id")Long id)throws PersonNotFoundException{
       
      
      FACADE.deletePerson(id+0l);
  
       
       
    }
    }

