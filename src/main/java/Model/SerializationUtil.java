/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author Voxiell
 */
public class SerializationUtil {
    /**
     * 
     * @param obj Objekt das serialisiert werden soll
     * @param filePath Path der Datei in der obj gepseichert werden soll
     * @throws IOException Datei existiert nicht
     */
    public static void serialize(Object obj, String filePath) throws IOException {
        FileOutputStream fos = new FileOutputStream(new File(filePath));
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        fos.close();
    }
    
    /**
     * 
     * @param filePath Path der Datei die deserialisiert werden soll
     * @return deserialisiertes Objekt
     * @throws IOException Datei existiert nicht
     * @throws ClassNotFoundException 
     */
    public static Object deserialize(String filePath) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object obj = ois.readObject();
        ois.close();
        return obj;
    }
}
