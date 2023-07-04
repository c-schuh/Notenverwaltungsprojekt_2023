/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author drago
 */
public record config(ArrayList<LeistungsnachweisArt> leistungsnachweisArten, ArrayList<NotenArt> notenArten, ArrayList<Integer> notenWerte) {

    public void addLeistungsnachweisArt(String name, NotenArt notenArt) {
        leistungsnachweisArten.add(new LeistungsnachweisArt(name, notenArt));
    }

    public void removeLeistungsnachweisArt(LeistungsnachweisArt toRemove) {
        leistungsnachweisArten.remove(toRemove);
    }

    public void addNotenArt(String name, int gewichtung) {
        notenArten.add(new NotenArt(name, gewichtung));
    }

    public void removeNotenArt(NotenArt toRemove) {
        notenArten.remove(toRemove);
    }

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
