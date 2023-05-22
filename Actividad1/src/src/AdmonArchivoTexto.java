/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.io.BufferedReader;
import java.io.File;
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
    
    public boolean existeArchivo(String nombreArchivo) {
        File f = new File(nombreArchivo);
        return f.exists();
    }

    void cerrarArchivoEscritura() throws IOException{
        if (fw != null) {
            fw.close();
        }
    }

    String leerArchivo(String nombreArchivo) throws IOException {
        fr = new FileReader(nombreArchivo);
        br = new BufferedReader(fr);
        String linea = br.readLine();
        String texto = linea;
        
        while   (linea != null) {
            linea = br.readLine();
            if (linea != null) {
                texto = texto + "\n" + linea;
            }
        }
        return texto;
    }

    void cerrarArchivoLectura() throws IOException {
        if (br != null) {
            br.close();
        }
    }
    
}
