/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Voxiell
 */
public class ModelSaveLoad {

    private final static String PATH ="./src/data/Leistungsabschnitte/";
    /**
     * deserialisere das searialisierte Leistungsabschnnitt-objekt "fileName" und gib es zurück
     * 
     * @param fileName Der Name der serialisierten Leistungsabschnitt Datei
     * @return Das deserialisierte Leistungsabschnitt-Objekt
     * @throws IOException Datei exisitiert nicht
     * @throws ClassNotFoundException 
     */
    public static Leistungsabschnitt ladeLeistungsabschnitt(String fileName) throws IOException, ClassNotFoundException{
       return (Leistungsabschnitt)SerializationUtil.deserialize(PATH + fileName);
    }
    /**
     * gebe alle Namen der Dateien im Leistungsabschnitt-directory zurück
     * 
     * @return Alle Dateinamen im Speicherdirectory in einem Array
     */
    public static String[] getLeistungsabschnittFileNamen() {
        File[] files = new File(PATH).listFiles();
        String[] ergebnisse = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                ergebnisse[i] = files[i].getName();
            }
        }
        return ergebnisse;
    }
    /**
     * serialisiere das Leistungsabschnitt-Objekt toSave und speichere dieses als Datei mit dem Namen des Leistungsabschnitts
     * 
     * @param toSave Das Leistungsabschnitt-Objekt das gepsiechert werden soll
     */
    public static void speicherLeistungsabschnitt(Leistungsabschnitt toSave){
        String fileName = toSave.getName() + ".ser";
        try {
            SerializationUtil.serialize(toSave, PATH + fileName);
        } catch (IOException ex) {
            Logger.getLogger(ModelSaveLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
