/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

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
    
    @Override
    public boolean equals(Object obj){
         // self check
    if (this == obj)
        return true;
    // null check
    if (obj == null)
        return false;
    // type check and cast
    if (getClass() != obj.getClass())
        return false;
    Leistungsabschnitt l = (Leistungsabschnitt) obj;
    // field comparison
    return Objects.equals(name, l.name)
            && Objects.equals(fächer, l.fächer);
    }
}
