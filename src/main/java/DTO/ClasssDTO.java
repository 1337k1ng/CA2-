/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Classs;

/**
 *
 * @author Madsj
 */
public class ClasssDTO {
     
    private String semester; 
    private int numberOfStudents;

    public ClasssDTO(Classs classs) {
        this.semester = classs.getSemester();
        this.numberOfStudents = classs.getNumberOfStudents();
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    
    
}
