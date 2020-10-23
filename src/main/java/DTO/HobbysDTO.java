/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Hobby;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick
 */
public class HobbysDTO {
 
    
    List<HobbyDTO> hobbys = new ArrayList();
            
     public HobbysDTO(){}
     public HobbysDTO(List<Hobby> h){
         
         for (Hobby h2 : h){
             hobbys.add(new HobbyDTO(h2));
         }
     
     }

    public List<HobbyDTO> getHobbys() {
        return hobbys;
    }
     
     
}
