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
public class Fach implements Serializable {
    
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
    Fach f = (Fach) obj;
    // field comparison
    return Objects.equals(name, f.name)
            && Objects.equals(noten, f.noten);
    }
}
