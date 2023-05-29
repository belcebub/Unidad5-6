/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Geraf
 */
public class Archivo {
    private FileOutputStream fos;
    private DataOutputStream dos;
    //Se utilizaran para leer en el archivo
    private FileInputStream fis;
    private DataInputStream dis;
    
    public boolean busqueda(int clave) {
        int cla;
        String nombre;
        float precio;
        char tipo;
        float vol;

        try {
            fis = new FileInputStream("Datos.dat");
            dis = new DataInputStream(fis);

            do {
                cla = dis.readInt();
                nombre = dis.readUTF();
                precio = dis.readFloat();
                tipo = dis.readChar();
                vol = dis.readFloat();
                if (clave == cla) {
                    return true;
                }
            } while (true);
        } catch (EOFException e) {
            return false;
        } catch (IOException e) {
            System.out.printf("Error: %s\n", e.getMessage());
            return false;
        }
    }
       
    
    public void altas(Cerveza c) {
        try {
            //Se crea/abre el archivo (Datos.dat) para escribir al final de este (true)
            fos = new FileOutputStream("Datos.dat", true);
            dos = new DataOutputStream(fos);
            
            //Se extraen uno a uno los datos del objeto p y se escriben en el archivo
            dos.writeInt(c.getClave());
            dos.writeUTF(c.getNombre());
            dos.writeFloat(c.getPrecio());
            dos.writeChar(c.getTipo());
            dos.writeFloat(c.getVolAlcohol());
        } catch (IOException e) {
            System.out.printf("Error: %s\n", e.getMessage());
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e){
                System.out.printf("Error: %s\n", e.getMessage());
            }
        }
    }
    
    public Cerveza consultaIndividual(int clave){
        int cla;
        String nombre;
        float precio;
        char tipo;
        float vol;
        boolean ban = false;
        Cerveza c = null;
        
        try {
            fis = new FileInputStream("Datos.dat");
            dis = new DataInputStream(fis);

            do {
                cla = dis.readInt();
                nombre = dis.readUTF();
                precio = dis.readFloat();
                tipo = dis.readChar();
                vol = dis.readFloat();
                if (clave == cla) {
                    c = new Cerveza(cla, nombre, precio, tipo, vol);
                    return c;
                }
            } while (true);
        } catch (EOFException e) {
            return null;
        } catch (IOException e) {
            System.out.printf("Error: %s\n", e.getMessage());
            return null;
        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }         
            } catch (IOException e) {
               System.out.printf("Error: %s\n", e.getMessage()); 
            }
        }
    }
    
    public String consultaGeneral(){
        String texto = "";
        try {
            //Se abre el archivo para leer su contenido
            fis = new FileInputStream("Datos.dat");
            dis = new DataInputStream(fis);
                
            do {
                texto += "Clave: " + dis.readInt() +
                "\nNombre: " + dis.readUTF() +
                "\nPrecio: " + dis.readFloat() + 
                "\nTipo: " + dis.readChar() +
                "\nVolumen de alcohol: " + dis.readFloat() + "%" +
                "\n----------------------------\n";
            } while (true);
        } catch (EOFException e) {
            System.out.println("FIN DE LA CONSULTA");
        } catch (IOException e) {
            System.out.printf("Error: %s\n", e.getMessage());
        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException e) {
                System.out.printf("Error: %s\n", e.getMessage());
            }
        }
        return texto;
    }
        
}
