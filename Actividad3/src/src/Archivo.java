/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Geraf
 */
public class Archivo {
    private RandomAccessFile raf;
    private final int TAM_REG;
    
    public Archivo(){
        raf = null;
        TAM_REG = 35;
    }
    public boolean busqueda(int clave) {
        try {

            raf = new RandomAccessFile("Datos.dat", "r");
            raf.seek(clave * TAM_REG - TAM_REG);
            int cla = raf.readInt();
            if (cla == clave) {
                return true;
            }
        } catch (EOFException e) {
            return false;
        } catch (IOException e) {
            System.out.printf("Error: %s\n", e.getMessage());
            return false;
        }
        return false;
    }
       
    
    public void altas(Cerveza c) {
        try {
            raf = new RandomAccessFile("Datos.dat","rw");
            raf.seek(c.getClave() * TAM_REG - TAM_REG);
            raf.writeInt(c.getClave());
            raf.writeUTF(c.getNombre());
            raf.writeFloat(c.getPrecio());
            raf.writeChar(c.getTipo());
            raf.writeFloat(c.getVolAlcohol());
        } catch (IOException e) {
            System.out.printf("Error: %s\n", e.getMessage());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e){
                System.out.printf("Error: %s\n", e.getMessage());
            }
        }
    }
    
    public Cerveza consultaIndividual(int clave){
        Cerveza c = null;
        
        try {
            raf = new RandomAccessFile("Datos.dat","r");
            raf.seek(c.getClave() * TAM_REG - TAM_REG);
            int cla = raf.readInt();
            if (cla == clave) {
                String nombre = raf.readUTF();
                float precio = raf.readFloat();
                char tipo = raf.readChar();
                float vol = raf.readFloat();
                c = new Cerveza(cla, nombre, precio, tipo, vol);
            }
            return c;
        } catch (EOFException e) {
            return null;
        } catch (IOException e) {
            System.out.printf("Error: %s\n", e.getMessage());
            return null;
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }         
            } catch (IOException e) {
               System.out.printf("Error: %s\n", e.getMessage()); 
            }
        }
    }
    
    public String consultaGeneral(){
        String texto = "";
        int clave, x =1;
        try {
            //Se abre el archivo para leer su contenido
            raf = new RandomAccessFile("Datos.dat", "r");
            do {
                raf.seek(x * TAM_REG - TAM_REG);
                clave = raf.readInt();
                texto += "Clave: " + raf.readInt()
                        + "\nNombre: " + raf.readUTF()
                        + "\nPrecio: " + raf.readFloat()
                        + "\nTipo: " + raf.readChar()
                        + "\nVolumen de alcohol: " + raf.readFloat() + "%"
                        + "\n----------------------------\n";
                x++;
            } while(true);
        } catch (EOFException e) {
            System.out.println("FIN DE LA CONSULTA");
        } catch (IOException e) {
            System.out.printf("Error: %s\n", e.getMessage());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException e) {
                System.out.printf("Error: %s\n", e.getMessage());
            }
        }
        return texto;
    }
        
}
