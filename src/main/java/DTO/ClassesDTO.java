/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Classs;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Madsj
 */
public class ClassesDTO {

    List<ClasssDTO> allClasses = new ArrayList();

    public ClassesDTO(List<Classs> classes) {

        classes.forEach((c) -> {
            allClasses.add(new ClasssDTO(c));
        });

    }

    public List<ClasssDTO> getAllClasses() {
        return allClasses;
    }

    public void setAllClasses(List<ClasssDTO> allClasses) {
        this.allClasses = allClasses;
    }

}
