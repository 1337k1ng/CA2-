/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entities.Course;
import entities.Role;
import entities.User;
import facades.CourseFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import security.errorhandling.AuthenticationException;

/**
 *
 * @author Madsj
 */
public class TestUser {

    static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    static EntityManager em = emf.createEntityManager();
    private static CourseFacade instance;

    public static void main(String[] args) throws AuthenticationException {

        /*
        //Opretter et Course
        Course coursee = new Course("Fysik", "A Niveau");

        Course courseee = new Course(coursee.getCourseName(), coursee.getDescription());
        
        instance.addNewCourse(coursee);

       
        em.getTransaction().begin();
        em.persist(coursee);
        em.getTransaction().commit();
        em.close(); 
        */
        
        User user1 = new User("Admin", "test1");
        User user2 = new User("Student", "test1");
        
        Role adminRole = new Role("admin");
        Role userRole = new Role("user");
        Role teacherRole = new Role("teacher");
       
       // user1.addRole(adminRole);
       // user2.addRole(userRole);
        
        em.getTransaction().begin();
        //em.persist(userRole);
       // em.persist(adminRole);
       em.persist(teacherRole);
       //  em.persist(user2);
        em.getTransaction().commit();
        em.close();
 
         
    }
}