package rest;

import DTO.PersonDTO;
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
    @GET
    @Path("all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAll() {
        return GSON.toJson(FACADE.getAllPersons());

}
   
        

    //All Persons having a specified hobby
    @GET
    @Path("hobby/{hobbyName}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getPersonsWithHobby(@PathParam("hobbyName")String hobby) throws HobbyNotFoundException {
          
     return GSON.toJson(FACADE.getAllPersonswithSpecifiedHobby(hobby));
   
    }
    
    
    //Id: All  info of specified Person: Person, Hobby, Address, CityInfo, Phone
    @GET
    @Path("id/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getPersonById(@PathParam("id")int id) {
        
        return "";
                //GSON.toJson(FACADE.getPersonByID(id));
        
    }
    
    
    //Finds a person with the specified phoneNumber
    @GET
    @Path("phone/{phonenumber}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getPersonByPhonenumber() {
        
        return "";
    }
    
    //api/persons/hobby/{hobby}/count
    @GET
    @Path("zip")
    @Produces({MediaType.APPLICATION_JSON})
    
    public String returnNumberOfCities(){
        return "";
    }
   
 //adds a person 
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String addPerson(String person) {
        
        Person personToAdd = GSON.fromJson(person,Person.class);
       
        FACADE.addNewPerson(personToAdd);
        return person;
        
       //Edit person chosen by ID  
    }
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})  
       
    public String editPersonById() {
        return "";
    }
    
    //Delete person chosen by ID. 
    @DELETE
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    
   public String deletePersonById(){
        return "";
    }
    }

