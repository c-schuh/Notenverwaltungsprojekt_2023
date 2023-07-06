/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 * standard setup durch static Methoden für Model Klassen für minimal Version
 * @author Voxiell
 */

public class StandardSetup {
    /**
     * erstellt ein Config-Objekt mit standard Werten
     * @return Config-Objekt mit standard Werten
     */
    public static Config configSetup(){
        Config standardConfig = new Config(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        standardConfig.addNotenArt("mündlich", 1);
        standardConfig.addNotenArt("schriftlich", 1);
        
        standardConfig.addLeistungsnachweisArt("kleiner Leistungsnachweis", standardConfig.notenArten().get(0));
        standardConfig.addLeistungsnachweisArt("großer Leistungsnachweis", standardConfig.notenArten().get(1));
        
        standardConfig.setNotenWerte(15, 0);
        return standardConfig;
    }
    
    /**
     * erstellt ein Leistungsabschnitt-Objekt mit standard Werten
     * @return Leistungsabschnitt-Objekt mit standard Werten
     */
    public static Leistungsabschnitt leistungsabschnittSetup(){
        Leistungsabschnitt standardLeistungsabschnitt = new Leistungsabschnitt("Q11_1");
        
        standardLeistungsabschnitt.addFach(new Fach("Mathe"));
        standardLeistungsabschnitt.addFach(new Fach("Deutsch"));
        standardLeistungsabschnitt.addFach(new Fach("Englisch"));
        standardLeistungsabschnitt.addFach(new Fach("Informatik"));
        standardLeistungsabschnitt.addFach(new Fach("Physik"));
        standardLeistungsabschnitt.addFach(new Fach("Geschichte"));
        standardLeistungsabschnitt.addFach(new Fach("Sozailkunde"));
        standardLeistungsabschnitt.addFach(new Fach("Ethik"));
        standardLeistungsabschnitt.addFach(new Fach("Geographie"));
        standardLeistungsabschnitt.addFach(new Fach("Sport"));
        standardLeistungsabschnitt.addFach(new Fach("W-Seminar"));
        standardLeistungsabschnitt.addFach(new Fach("P-Seminar"));
        
        return standardLeistungsabschnitt;
    }
}
