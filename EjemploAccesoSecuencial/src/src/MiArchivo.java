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
 * @author beelze
 */
public class MiArchivo {
    //Para escribir en el archivo
    private FileOutputStream fos;
    private DataOutputStream dos;
    
    //Para leer desde el archivo
    private FileInputStream fis;
    private DataInputStream dis;
    
    //El metodo altasrecibe como parametro el objeto p de la clase Persona
    public void altas(Persona p) {
        try {
            //Se crea/abre el archivo (Datos.dat) para escribir al final de este (true)
            fos = new FileOutputStream("Datos.dat", true);
            dos = new DataOutputStream(fos);
            
            //Se extraen uno a uno los datos del objeto p y se escriben en el archivo
            dos.writeUTF(p.getNombre());
            dos.writeInt(p.getEdad());
            dos.writeFloat(p.getEstatura());
        } catch (IOException e){
            System.out.printf("Error: %s\n", e.getMessage() );
        } finally {
            try {
                //Cerramos el filtro el cual a su vez cierra el flujo 
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException e) {
                System.out.printf("Error: %s\n", e.getMessage());
            }
        }
    }
    
    //El metodo consultaIndividual recibe como parametro el nombre de la presona a consultar
    public Persona consultaIndividual(String nombre) {
        String nom;
        int edad;
        float estatura;
        boolean ban = false;
        Persona p = null;
        
        try {
            //Se abre el archivo para leer si contenido 
            fis = new FileInputStream("Datos.dat");
            dis = new DataInputStream(fis);
            
            /*
            Se realiza una busqueda del nombre recibido como parametro.
            Si se localiza se construye el objeto p de la clase Persona con los datos
            leidos en el archivo y se retorna p. Si se recorre todo el archivo y no se
            localiza el nombre llegaremos al final del archivo, lanzandose una excepcion
            de final de archivo (EOFEXception), la cual retorna null, que indica que no se
            localizo a alguna persona con ese nombre. En caso de que suceda algun otro
            tipo de excepcion de e/s, imprimimos el mensaje asociado a la excepcion y tambien
            retornamos null.
            */
            do {
                nom = dis.readUTF();
                edad = dis.readInt();
                estatura = dis.readFloat();
                if (nombre.equals(nom)) {
                    p = new Persona(nom, edad, estatura);
                    return p;
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
            } catch (IOException e){
                System.out.printf("Error: %s\n", e.getMessage());
            }
        }
    }
    
    //El metodo consultaGeneral visualiza todos los registros del archivo, esto es,
    //los datos de todas las personas
    public void consultaGeneral(){
        try {
            //Se abre el archivo para leer su contenido
            fis = new FileInputStream("Datos.dat");
            dis = new DataInputStream(fis);
        }
    }
}
