/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Madsj
 */
@Entity
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private String description;
    
     //NOTE: Mapped by skal være på "one" siden ("many" siden indeholder fremmednøglen og er dermed ejersiden)
   @OneToMany(mappedBy = "Course", cascade = CascadeType.PERSIST)
       private List<Classs> classesList;

    public Course(String courseName, String description) {
        
        this.courseName = courseName;
        this.description = description;
     
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Classs> getClassesList() {
        return classesList;
    }

    public void setClassesList(List<Classs> classesList) {
        this.classesList = classesList;
    }

   
}
