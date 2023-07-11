/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.Serializable;

/**
 * Notenart mit Name und Gewichtung
 *
 * @author drago
 */
public record NotenArt(String name, int gewichtung) implements Serializable {

}
