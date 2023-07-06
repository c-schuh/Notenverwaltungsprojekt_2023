/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Voxel
 */
import Model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ModelTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //erstellen von test objekten
        Config c = new Config(new ArrayList<LeistungsnachweisArt>(), new ArrayList<NotenArt>(), new ArrayList<Integer>());
        c.setNotenWerte(15, 0);
        c.addNotenArt("mündlich", 1);
        c.addLeistungsnachweisArt("Abfrage", c.notenArten().get(0));
        
        Leistungsabschnitt l = new Leistungsabschnitt("Q11_1");
        for (int i = 0; i < 10; i++) {
           Fach toAdd = new Fach("fach" + i);
           toAdd.addNote(new NotenElement(15, c.notenArten().get(0), c.leistungsnachweisArten().get(0), new Date(1, 1, 2023), "test"));
           l.addFach(toAdd);
        }
        
        //serialisierung der test objekte
        ModelSaveLoad.speicherConfig(c);
        ModelSaveLoad.speicherLeistungsabschnitt(l);
        Config c2 = null;
        Leistungsabschnitt l2 = null;
        
        //deserialisieren der test-Objekte und speicherung in l2 und c2
        try {
            c2 = ModelSaveLoad.ladeConfig();
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("config save fail");
        }
        
        try {
            l2 = ModelSaveLoad.ladeLeistungsabschnitt(ModelSaveLoad.getLeistungsabschnittFileNamen()[0]);
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println("Leistungsabschnitt save fail");
        }
        
        //vergleichen der orginalen test-Objekte mit deserialiserten test-Objekten
        System.out.println("Config is same: " + c.equals(c2));
        System.out.println("Leistungsabschnitt is same: " + l.equals(l2));
        
    }
    
}
