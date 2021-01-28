/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Course;
import facades.CourseFacade;
import facades.UserFacade;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import security.errorhandling.AuthenticationException;
import utils.EMF_Creator;

/**
 *
 * @author Madsj
 */
@Path("course")
public class CourseResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final UserFacade UserFACADE = UserFacade.getUserFacade(EMF);
    private static final CourseFacade cf = CourseFacade.getCourseFacade(EMF);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("addCourse")
    @RolesAllowed("admin")

    public String newCourse(String courseToAdd) throws AuthenticationException {
        Course coursePlaceholder = GSON.fromJson(courseToAdd, Course.class);
        Course addedCourse = cf.addNewCourse(coursePlaceholder);
        return "{\"msg\": \"Course added  \"}";
    }
    
 @Path("getallcourses")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCourses() {
    return GSON.toJson(cf.getAllCourses());
    }
}