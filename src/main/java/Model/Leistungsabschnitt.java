/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Leistungsabschnitt, der die Fächer verwaltet
 *
 * @author drago
 */
public class Leistungsabschnitt implements Serializable {

    private String name;
    private ArrayList<Fach> fächer = new ArrayList();

    /**
     * erstellt einen Leistungsabschnitt
     *
     * @param name Name des Leistungsabschnittes
     */
    public Leistungsabschnitt(String name) {
        this.name = name;

    }

    /**
     * erstellt einen Leistungsabschnitt
     *
     * @param name Name des Leistungsabschnittes
     * @param fächer Fächer in dem Leistungsabschnittes
     */
    public Leistungsabschnitt(String name, ArrayList<Fach> fächer) {
        this.name = name;
        this.fächer = fächer;
    }

    /**
     * gibt Name des Leistungsabschnittes zurück
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setzt den Namen des Leistungsabschnittes
     *
     * @param name Name des Leistungsabschnittes
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gibt die Fächer innerhalb des Leistungsabschnittes zurück
     *
     * @return fächer
     */
    public ArrayList<Fach> getFächer() {
        return fächer;
    }

    /**
     * setzt die Fächer innerhalb eines Leistungsabschnittes
     *
     * @param fächer Fächer innerhalb des Leistungsabschnittes
     */
    public void setFächer(ArrayList<Fach> fächer) {
        this.fächer = fächer;
    }

    /**
     * fügt Fach in die ArrayList fächer hinzu
     *
     * @param toAdd Fach das hinzugefügt werden soll
     */
    public void addFach(Fach toAdd) {
        fächer.add(toAdd);
    }

    /**
     * entfernt Fach aus der ArrayList fächer
     *
     * @param toRemove Fach das entfernt werden soll
     */
    public void removeFach(Fach toRemove) {
        fächer.remove(toRemove);
    }

    /**
     * vergleicht Leistungsabschnitte nach den Attributen
     *
     * @param obj Objekt, mit dem es verglichen werden soll
     * @return Ergebnis
     */
    @Override
    public boolean equals(Object obj) {
        // self check
        if (this == obj) {
            return true;
        }
        // null check
        if (obj == null) {
            return false;
        }
        // type check and cast
        if (getClass() != obj.getClass()) {
            return false;
        }
        Leistungsabschnitt l = (Leistungsabschnitt) obj;
        // field comparison
        return Objects.equals(name, l.name)
                && Objects.equals(fächer, l.fächer);
    }
}
