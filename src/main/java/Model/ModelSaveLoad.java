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
 * Hilfsklasse, die das Laden und Speichern von Leistungsabschnitten übernimmt
 * @author Voxiell
 */
public class ModelSaveLoad {
    //Path für das File directory für die Speicherung der Leistungsabschnitte
    private final static String PATH_LEISTUNGSABSCHNITTE ="./src/data/Leistungsabschnitte/";
    
    //Path für das File directory für die Speicherung der Config
    private final static String PATH_CONFIG = "./src/data/";
    /**
     * deserialisere das searialisierte Leistungsabschnnitt-objekt "fileName" und gib es zurück
     * 
     * @param fileName Name der serialisierten Leistungsabschnitt Datei
     * @return deserialisiertes Leistungsabschnitt-Objekt
     * @throws IOException Datei exisitiert nicht
     * @throws ClassNotFoundException 
     */
    public static Leistungsabschnitt ladeLeistungsabschnitt(String fileName) throws IOException, ClassNotFoundException{
       return (Leistungsabschnitt)SerializationUtil.deserialize(PATH_LEISTUNGSABSCHNITTE + fileName);
    }
    /**
     * gebe alle Namen der Dateien im Leistungsabschnitt-directory zurück
     * 
     * @return Alle Dateinamen im Speicherdirectory in einem Array
     */
    public static String[] getLeistungsabschnittFileNamen() {
        File[] files = new File(PATH_LEISTUNGSABSCHNITTE).listFiles();
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
     * @param toSave Leistungsabschnitt-Objekt das gepsiechert werden soll
     */
    public static void speicherLeistungsabschnitt(Leistungsabschnitt toSave){
        String fileName = toSave.getName() + ".ser";
        try {
            SerializationUtil.serialize(toSave, PATH_LEISTUNGSABSCHNITTE + fileName);
        } catch (IOException ex) {
            Logger.getLogger(ModelSaveLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @return deserialisiertes Config-Objekt
     * @throws ClassNotFoundException
     * @throws IOException Datei konnte nicht gefunden werden
     */
    public static Config ladeConfig() throws ClassNotFoundException, IOException{
        return (Config) SerializationUtil.deserialize(PATH_CONFIG + "config.ser");
    }
    
    /**
     * 
     * @param toSave Config-Objekt das gespeichert werden soll 
     */
    public static void speicherConfig(Config toSave){
        try {
            SerializationUtil.serialize(toSave, PATH_CONFIG + "config.ser");
        } catch (IOException ex) {
            Logger.getLogger(ModelSaveLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
