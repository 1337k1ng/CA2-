/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Phone;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Patrick
 */
public class PhonesDTO {
    
    List<PhoneDTO> phoneDTOS = new ArrayList();
    
     public PhonesDTO(){}
    public PhonesDTO(List<Phone> phones){
        for (Phone p : phones){
            phoneDTOS.add(new PhoneDTO(p));
        }
    }

    public List<PhoneDTO> getPhoneDTOS() {
        return phoneDTOS;
    }
 
    
    
}
