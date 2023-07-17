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
import Model.NotenElement;
import Model.StandardSetup;
import java.util.Date;
import View.Halbjahr;

/**
 *
 * @author Voxiell, simon
 */
public class Control { 
    
    public Leistungsabschnitt leistungsabschnittakt;

    /**
     * MVC-Control Klasse: Konstroktor initialisiert View und Model
     */
   public Control () {
     View view1=new Halbjahr(this); //Kon struktor der Klasse Halbjahr hat keine Variable für die Control, welches ist der Startbildschirm?
      //aktuellen Leistungsabschnitt festlegen:
      if (ModelSaveLoad.getLeistungsabschnittFileNamen().length==0){
          
          //sage Gui Leistungsabschnitt erstellen
          // else Zeige GUI verfügbare Leistungsabschnitte und lasse wählen
          leistungsabschnittakt=StandardSetup.leistungsabschnittSetup();
      }
   }
   
   //fügt neuen Leistungsabschnitt hinzu // Verwaltung des Leistungsabschnittes?
   public void Leistungsabschnitthinzufügen (String name){
       leistungsabschnittakt = new Leistungsabschnitt(name);
       ModelSaveLoad.speicherLeistungsabschnitt(leistungsabschnittakt);
       
   }
   
   //fügt Fach zu Leistungsabschnitt hinzu
   public void Fachhinzufügen (String name){
      leistungsabschnittakt.addFach(new Fach(name));
      ModelSaveLoad.speicherLeistungsabschnitt(leistungsabschnittakt);
   }
   
   
   //Fügt Note zu gewähltem Fach im aktuellen Leistungsabschnitt hinzu
   public void Notehinzufügen (int gewFachIndex, int note, LeistungsnachweisArt leistungsnachweisArt, Date datum, String beschreibung){
       //leistungsabschnittakt.Fächer[Fach]();
       
       leistungsabschnittakt.getFächer().get(gewFachIndex).addNote(new NotenElement(note,leistungsnachweisArt.notenArt(),leistungsnachweisArt,datum,beschreibung));
       //Fächer an die View übergeben oder direkt vom Model (vorher), View Liefert gewähltes Fach und Andere Daten, control setzt sie ein
       ModelSaveLoad.speicherLeistungsabschnitt(leistungsabschnittakt);
   }
   
   // löscht Leistungsabschnitt
   public void LeistungsabschnittLoeschen (Leistungsabschnitt zuloeschen){
       ModelSaveLoad.speicherLeistungsabschnitt(null);
       
   }
   
   //löscht Fach
   public void Fachloeschen (Fach zuloeschen){
       leistungsabschnittakt.removeFach(zuloeschen);
       ModelSaveLoad.speicherLeistungsabschnitt(leistungsabschnittakt);
   }
   
   //löscht Fach
   public void Noteloeschen (int gewFachIndex, NotenElement zuloeschen){
       leistungsabschnittakt.getFächer().get(gewFachIndex).removeNote(zuloeschen);    
       ModelSaveLoad.speicherLeistungsabschnitt(leistungsabschnittakt);
   }
   
   
   public void prüfeEingabe(){
       // evtl. über View
   }
   
       
    
}
