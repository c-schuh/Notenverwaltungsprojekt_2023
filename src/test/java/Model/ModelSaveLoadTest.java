/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Voxel
 */
public class ModelSaveLoadTest {

    static Config c;
    static Leistungsabschnitt l;

    @BeforeAll
    public static void setUpTestObjects() {
        //erstellen von test objekten
        c = new Config(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        c.setNotenWerte(15, 0);
        c.addNotenArt("mündlich", 1);
        c.addLeistungsnachweisArt("Abfrage", c.notenArten().get(0));

        l = new Leistungsabschnitt("Q11_1");
        for (int i = 0; i < 10; i++) {
            Fach toAdd = new Fach("fach" + i);
            toAdd.addNote(new NotenElement(15, c.notenArten().get(0), c.leistungsnachweisArten().get(0), new Date(1, 1, 2023), "test"));
            l.addFach(toAdd);
        }
    }

    @AfterAll
    public static void tearDownClass() {
        l = null;
        c = null;
    }
    
    @AfterEach
    public void clearDirectory(){
        File configDirectory = new File(ModelSaveLoad.PATH_CONFIG);
        for (File file : configDirectory.listFiles()) {
           if(!file.getName().equalsIgnoreCase("README.md")){
                file.delete();
            }   
        }
        
        File dataDirectory = new File(ModelSaveLoad.PATH_LEISTUNGSABSCHNITTE);
        for (File file : dataDirectory.listFiles()) {
            if(!file.getName().equalsIgnoreCase("README.md")){
                file.delete();
            }   
        }
    }

    @Test
    public void serialisationConfig() throws ClassNotFoundException, IOException {
        ModelSaveLoad.speicherConfig(c);
        Config c_deserialized = ModelSaveLoad.ladeConfig();
        assertEquals(c, c_deserialized);
    }

    @Test
    public void serialisationLeistungsabschnitt() throws ClassNotFoundException, IOException {
        ModelSaveLoad.speicherLeistungsabschnitt(l);
        Leistungsabschnitt l_deserialized = ModelSaveLoad.ladeLeistungsabschnitt(ModelSaveLoad.getLeistungsabschnittFileNamen()[0]);
        assertEquals(l, l_deserialized);
    }
    
    @Test
    public void overwrite() throws IOException, ClassNotFoundException{
        //speicher Leistungsabschnitt in eine Variable nach serialisations-prozess
        ModelSaveLoad.speicherLeistungsabschnitt(l);
        Leistungsabschnitt l_deserialized = ModelSaveLoad.ladeLeistungsabschnitt(ModelSaveLoad.getLeistungsabschnittFileNamen()[0]);
        //verändere Leistungsabschnitt und speicher ihn in eine andere Variable nach serialisations-prozess
        l.addFach(new Fach("änderung"));
        ModelSaveLoad.speicherLeistungsabschnitt(l);
        Leistungsabschnitt l_changed_deserialized = ModelSaveLoad.ladeLeistungsabschnitt(ModelSaveLoad.getLeistungsabschnittFileNamen()[0]);
        //vergleiche die beiden gespeicherten Objekte, Erwartung: Änderung wurde gespeichert(überschrieben)
        assertFalse(l_deserialized.equals(l_changed_deserialized));
    }
    
    @Test
    public void delete(){
        ModelSaveLoad.speicherLeistungsabschnitt(l);
        ModelSaveLoad.löscheLeistungsabschnitt(ModelSaveLoad.getLeistungsabschnittFileNamen()[0]);
        assertEquals(0, ModelSaveLoad.getLeistungsabschnittFileNamen().length);
    }
}


