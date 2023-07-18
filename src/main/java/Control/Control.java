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
import static Model.ModelSaveLoad.löscheLeistungsabschnitt;
import Model.NotenElement;
import Model.StandardSetup;
import java.util.Date;
import View.Halbjahr;

/**
 *
 * @author Voxiell, simon
 */
public class Control { 
    
    /**
     *
     */
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
   

    /**
     *     fügt neuen Leistungsabschnitt hinzu Verwaltung des Leistungsabschnittes?

     * @param name
     */
   public void Leistungsabschnitthinzufügen (String name){
       leistungsabschnittakt = new Leistungsabschnitt(name);
       ModelSaveLoad.speicherLeistungsabschnitt(leistungsabschnittakt);
       
   }
   

    /**
     *   fügt Fach zu Leistungsabschnitt hinzu

     * @param name
     */
   public void Fachhinzufügen (String name){
      leistungsabschnittakt.addFach(new Fach(name));
      ModelSaveLoad.speicherLeistungsabschnitt(leistungsabschnittakt);
   }
   
   

    /**
     *
     * @param gewFachIndex
     * @param note
     * @param leistungsnachweisArt
     * @param datum
     * @param beschreibung
     * 
     *  Fügt Note zu gewähltem Fach im aktuellen Leistungsabschnitt hinzu
     */
   public void Notehinzufügen (int gewFachIndex, int note, LeistungsnachweisArt leistungsnachweisArt, Date datum, String beschreibung){
       //leistungsabschnittakt.Fächer[Fach]();
       
       leistungsabschnittakt.getFächer().get(gewFachIndex).addNote(new NotenElement(note,leistungsnachweisArt.notenArt(),leistungsnachweisArt,datum,beschreibung));
       //Fächer an die View übergeben oder direkt vom Model (vorher), View Liefert gewähltes Fach und Andere Daten, control setzt sie ein
       ModelSaveLoad.speicherLeistungsabschnitt(leistungsabschnittakt);
   }
   

    /**
     *    löscht Leistungsabschnitt

     * @param zuloeschen
     */
   public void LeistungsabschnittLoeschen (String zuloeschen){ //Vom Drop-Down aus der View
       löscheLeistungsabschnitt(zuloeschen);
    }
   

    /**
     *  löscht Fach

     * @param zuloeschen
     */
   public void Fachloeschen (Fach zuloeschen){
       leistungsabschnittakt.removeFach(zuloeschen);
       ModelSaveLoad.speicherLeistungsabschnitt(leistungsabschnittakt);
   }
   
   //löscht Fach

    /**
     *
     * @param gewFachIndex
     * @param zuloeschen
     */
   public void Noteloeschen (int gewFachIndex, NotenElement zuloeschen){
       leistungsabschnittakt.getFächer().get(gewFachIndex).removeNote(zuloeschen);    
       ModelSaveLoad.speicherLeistungsabschnitt(leistungsabschnittakt);
   }
   

    /**
     *
     * @param gewFachIndex
     * @param zubearbeiten
     * @param note
     * @param leistungsnachweisArt
     * @param datum
     * @param beschreibung
     * 
     * löscht alte Version der Note und erstellt neue

     */
   public void Notebearbeiten(int gewFachIndex, NotenElement zubearbeiten, int note, LeistungsnachweisArt leistungsnachweisArt, Date datum, String beschreibung) {
       Noteloeschen (gewFachIndex, zubearbeiten);
       Notehinzufügen (gewFachIndex, note, leistungsnachweisArt, datum, beschreibung);
       ModelSaveLoad.speicherLeistungsabschnitt(leistungsabschnittakt);
   }
   

    /**
     *    Methoden um bestehende Informationen(Noten) aus dem Model abzurufen im Controller oder in der View?

     */
   
   public void prüfeEingabe(){
       // evtl. über View
   }
   
       
    
}
