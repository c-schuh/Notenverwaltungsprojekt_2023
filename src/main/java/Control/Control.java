/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import View.View;
import Model.Fach;
import Model.Leistungsabschnitt;
import Model.LeistungsnachweisArt;
import Model.NotenArt;
import Model.NotenElement;

/**
 *
 * @author Voxiell, simon
 */
public class Control { 
    // Startup Initialisiert das Programm mit Model und View. Mach des Sinn?
   public void startup () {
      View1=new View(this);
      Model1 = new Model();
      View1.setModel(Model1);
   }
   
   //fügt neuen Leistungsabschnitt hinzu
   public boolean Leistungsabschnitthinzufügen (String name){
       new Leistungsabschnitt(name);
       return true;
       
   }
   
   //fügt Fach zu Leistungsabschnitt hinzu
   public boolean Fachhinzufügen (String name, int Leistungsabschnitt){
      Leistungsabschnitt.addFach(new Fach(name));
       
       return true;
       
   }
   
   public boolean Notehinzufügen (String name, String Fach, int Notenwert){
       
       
   }
       
    
}
