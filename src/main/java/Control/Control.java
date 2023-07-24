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
     * MVC-Control Klasse: Konstruktor initialisiert View und Model
     */
   public Control () {
      //Kon struktor der Klasse Halbjahr hat keine Variable für die Control, welches ist der Startbildschirm?
      //Starbildschirm der View initialisieren:
      Halbjahr view1=new Halbjahr();
      //aktuellen Leistungsabschnitt festlegen:
      if (ModelSaveLoad.getLeistungsabschnittFileNamen().length==0){
          //sage Gui Leistungsabschnitt erstellen
          // else Zeige GUI verfügbare Leistungsabschnitte und lasse wählen
          leistungsabschnittakt=StandardSetup.leistungsabschnittSetup();
      }else{
          leistungsabschnittakt=ModelSaveLoad.ladeLeistungsabschnitt(ModelSaveLoad.getLeistungsabschnittFileNamen()[0]);
          //vorerst kann nur ein Leistungsabschnitt gespeichert, welcher logischerweise auf Position 0 liegt 
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
    * 
    * @param fachindex
    * @return fachname
    * 
    * stellt die Fachnamen für die Startseite bereit
    */
   public String getFachname(int fachindex){
       return leistungsabschnittakt.getFächer().get(fachindex).getName();
   }
   
   /**
    * 
    * @param fachindex
    * @return notenwerteschriftl
    * 
    * gibt eine Array aller schriftlichen Notenwerte eines gewählten fachindexes im aktuellen leistungsabschnitt zurück
    */
   public int[] getNotenwerteschriftl(int fachindex){
       int[] notenwerteschriftl = new int[leistungsabschnittakt.getFächer().get(fachindex).getNoten().size()];
       int y=0;
       for (int i=0; i<notenwerteschriftl.length; i++){
           if(leistungsabschnittakt.getFächer().get(fachindex).getNoten().get(i).notenArt().gewichtung()==2){
               notenwerteschriftl[y]=leistungsabschnittakt.getFächer().get(fachindex).getNoten().get(i).note();
               y=y+1;
           }
           
       }
       return notenwerteschriftl;
   }
   
    /**
    * 
    * @param fachindex
    * @return notenwertemündl
    * 
    * gibt eine Array aller mündlichen Notenwerte eines gewählten fachindexes im aktuellen Leistungsabschnitt zurück
    */
   public int[] getNotenwertemündl(int fachindex){
       int[] notenwerteschriftl = new int[leistungsabschnittakt.getFächer().get(fachindex).getNoten().size()];
       int y=0;
       for (int i=0; i<notenwerteschriftl.length; i++){
           if(leistungsabschnittakt.getFächer().get(fachindex).getNoten().get(i).notenArt().gewichtung()==1){
               notenwerteschriftl[y]=leistungsabschnittakt.getFächer().get(fachindex).getNoten().get(i).note();
               y=y+1;
           }
           
       }
       return notenwerteschriftl;
   }  
       
    
}
