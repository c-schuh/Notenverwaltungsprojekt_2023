/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Fach, dass die Noten des jeweiligen verwaltet
 *
 * @author drago
 */
public class Fach implements Serializable {

    private ArrayList<NotenElement> noten = new ArrayList<NotenElement>();
    private String name;

    /**
     * setzt Namen des Faches
     *
     * @param name Name des Faches
     */
    public Fach(String name) {
        this.name = name;
    }

    /**
     * gibt die Noten des Faches zurück
     *
     * @return noten
     */
    public ArrayList<NotenElement> getNoten() {
        return noten;
    }

    /**
     * setzt Noten des Faches
     *
     * @param noten Noten des Faches
     */
    public void setNoten(ArrayList<NotenElement> noten) {
        this.noten = noten;
    }

    /**
     * gibt den Namen des Faches zurück
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setzt Namen des Faches
     *
     * @param name Name des Faches
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * fügt eine neue Note dem Fach hinzu
     *
     * @param neueNote neue Note innerhalb eines Faches
     */
    public void addNote(NotenElement neueNote) {
        noten.add(neueNote);
    }

    /**
     * entfernt eine Note aus dem Fach
     *
     * @param toRemove Note die entfernt werden soll
     */
    public void removeNote(NotenElement toRemove) {
        noten.remove(toRemove);
    }

    /**
     * vergleicht Fachobjekte
     *
     * @param obj Objekte, die verglichen werden sollen
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
        Fach f = (Fach) obj;
        // field comparison
        return Objects.equals(name, f.name)
                && Objects.equals(noten, f.noten);
    }
}
