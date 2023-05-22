/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Belzee
 * 
 */
public class AdmonArchivoTexto {
    FileWriter fw;
    FileReader fr;
    BufferedReader br;
    
    public AdmonArchivoTexto() {
        fw = null;
        fr = null;
        br = null;
    }
    
    public void guardarArchivo(String nombreArchivo, String texto) throws IOException{
        fw = new FileWriter(nombreArchivo);
        fw.write(texto);
    }
}
