/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import View.View;
import Model.Fach;
import Model.ModelSaveLoad;
import Model.Leistungsabschnitt;
import Model.LeistungsnachweisArt;
import Model.NotenArt;
import Model.NotenElement;
import java.util.Date;


/**
 *
 * @author Voxiell, simon
 */
public class Control { 
    
    public Leistungsabschnitt leistungsabschnittakt;

    // Startup Initialisiert das Programm mit Model und View. Mach des Sinn?
   public void startup () {
      View View1=new View(this);
      //Model Model1 = new Model();
      //View1.setModel(Model1);
      //aktuellen Leistungsabschnitt festlegen:
      if (ModelSaveLoad.getLeistungsabschnittFileNamen().length==0){
          //sage Gui Leistungsabschnitt erstellen
          // else Zeige GUI verfügbare Leistungsabschnitte und lasse wählen
      }
   }
   
   //fügt neuen Leistungsabschnitt hinzu // Verwaltung des Leistungsabschnittes?
   public boolean Leistungsabschnitthinzufügen (String name){
       leistungsabschnittakt = new Leistungsabschnitt(name);
       ModelSaveLoad.speicherLeistungsabschnitt(leistungsabschnittakt);
       return true;
       
   }
   
   //fügt Fach zu Leistungsabschnitt hinzu
   public boolean Fachhinzufügen (String name){
      leistungsabschnittakt.addFach(new Fach(name));
      ModelSaveLoad.speicherLeistungsabschnitt(leistungsabschnittakt);
      return true;
   }
   
   
   //Fügt Note zu gewähltem Fach im aktuellen Leistungsabschnitt hinzu
   public boolean Notehinzufügen (int gewFachIndex, int note, LeistungsnachweisArt leistungsnachweisArt, Date datum, String beschreibung){
       //leistungsabschnittakt.Fächer[Fach]();
       
       leistungsabschnittakt.getFächer().get(gewFachIndex).addNote(new NotenElement(note,leistungsnachweisArt.notenArt(),leistungsnachweisArt,datum,beschreibung));
       //Fächer an die View übergeben oder direkt vom Model (vorher), View Liefert gewähltes Fach und Andere Daten, control setzt sie ein
       ModelSaveLoad.speicherLeistungsabschnitt(leistungsabschnittakt);
       return true;
   }
   
   
       
    
}
