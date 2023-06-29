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
public class Fach {
    
   private ArrayList<NotenElement> noten = new ArrayList<NotenElement>();
   private String name; 

    public Fach(String name) {
        this.name = name;
    }

    public ArrayList<NotenElement> getNoten() {
        return noten;
    }

    public void setNoten(ArrayList<NotenElement> noten) {
        this.noten = noten;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void addNote(NotenElement neueNote)
    {
        noten.add(neueNote);
    }
    
    public void removeNote (NotenElement toRemove)
    {
        noten.remove(toRemove);
    }
}
