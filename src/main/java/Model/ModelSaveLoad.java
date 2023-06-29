/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Voxiell
 */
public class ModelSaveLoad {

    public static Leistungsnachweis ladeLeistungsabschnitt(String fileName) throws IOException, ClassNotFoundException{
       return SerializationUtil.deserialize("./src/data/Leistungsabschnitte/" + fileName);
    }

    public static String[] getLeistungsabschnittFileNamen() {

        File[] files = new File("/path/to/the/directory").listFiles();

        String[] ergebnisse = new String[files.length];

        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                ergebnisse[i] = files[i].getName();
            }
        }
        return ergebnisse;
    }
}
