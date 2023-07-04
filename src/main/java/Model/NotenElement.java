/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author drago
 */
public record NotenElement(int note,NotenArt notenArt,LeistungsnachweisArt leistungsnachweisArt,Date datum,String beschreibung) implements Serializable {
    
   

   
    
    
}
