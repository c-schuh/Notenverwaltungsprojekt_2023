/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author drago
 */
public class Leistungsabschnitt implements Serializable {
    
    private String name;
    private ArrayList<Fach> fächer = new ArrayList();


    public Leistungsabschnitt(String name) {
        this.name = name;
        
    }
    
    public Leistungsabschnitt(String name, ArrayList<Fach> fächer) {
        this.name = name;
        this.fächer = fächer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Fach> getFächer() {
        return fächer;
    }

    public void setFächer(ArrayList<Fach> fächer) {
        this.fächer = fächer;
    }
    
    public void addFach(Fach toAdd){
        fächer.add(toAdd);
    }
    
    public void removeFach(Fach toRemove){
        fächer.remove(toRemove);
    }
    
    
}
