/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Belzee
 */
public class FiltroTxt extends FileFilter {

    public FiltroTxt() {
    }

    @Override
    public boolean accept(File f) {
        String nombre = f.getName().toLowerCase();
        if (nombre != null) {
            if(nombre.endsWith(".txt")){ 
                return true;
            }
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Archivos txt";
    }
    
}
