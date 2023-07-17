/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Klasse, die Einstellungen verwaltet
 *
 * @author drago
 */
public record Config(ArrayList<LeistungsnachweisArt> leistungsnachweisArten, ArrayList<NotenArt> notenArten, ArrayList<Integer> notenWerte) implements Serializable {

    /**
     * fügt eine neue Leistungsnachweisart hinzu
     *
     * @param name Name der Leistungsnachweisart
     * @param notenArt Notenart der neuen Leistungsnachweisart
     */
    public void addLeistungsnachweisArt(String name, NotenArt notenArt) {
        leistungsnachweisArten.add(new LeistungsnachweisArt(name, notenArt));
    }

    /**
     * entfernt eine Leistungsnachweisart
     *
     * @param toRemove Leistungsnachweisart, die entfernt werden soll
     */
    public void removeLeistungsnachweisArt(LeistungsnachweisArt toRemove) {
        leistungsnachweisArten.remove(toRemove);
    }

    /**
     * fügt eine neue Notenart hinzu
     *
     * @param name Name der Notenart
     * @param gewichtung Gewichtung der Notenart
     */
    public void addNotenArt(String name, int gewichtung) {
        notenArten.add(new NotenArt(name, gewichtung));
    }

    /**
     * entfernt eine Notenart
     *
     * @param toRemove Notenart, die entfernt werden soll
     */
    public void removeNotenArt(NotenArt toRemove) {
        notenArten.remove(toRemove);
    }

    /**
     * setzt Notenwerte
     *
     * @param best beste Note
     * @param worst schlechteste Note
     */
    public void setNotenWerte(int best, int worst) {
        notenWerte.clear();

        boolean aufsteigend;
        if (best > worst) {
            aufsteigend = true;
        } else {
            aufsteigend = false;

        }
        for (int i = 0; i <= Math.abs(best - worst); i++) {
            if (aufsteigend == true) {
                notenWerte.add(best - i);
            } else {
                notenWerte.add(best + i);
            }
        }
    }
}

