/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.util.Scanner;

/**
 *
 * @author beelze
 */
public class PruebaMiArchivo {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        MiArchivo ma = new MiArchivo();
        String nombre;
        int edad;
        float estatura;
        int opc;
        Persona p;

        do {
            System.out.println("\nCATALOGO DE PERSONAS");
            System.out.println("1. Altas");
            System.out.println("2. Consulta individual");
            System.out.println("3. Consulta general");
            System.out.println("4. Salir");
            System.out.println("¿Opcion deseada? [1-4]: ");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("\n---Altas---");
                    System.out.println("---Ingrese los datos de la persona---");
                    leer.nextLine();
                    System.out.print("Nombre: ");
                    nombre = leer.nextLine();
                    if (ma.busqueda(nombre) != true) {
                        System.out.print("Edad: ");
                        edad = leer.nextInt();
                        System.out.print("Estatura: ");
                        estatura = leer.nextFloat();
                        //Construimos el objeto de la persona p
                        p = new Persona(nombre, edad, estatura);
                        //enviamos el p al metodo de altas
                        ma.altas(p);
                        System.out.println("Alta exitosa");
                        System.out.println("Para continuar pulse ENTER...");
                        leer.nextLine();
                        leer.nextLine();
                        break;
                    } else {
                        System.out.println("Ya existe un paciente con ese nombre");
                        break;
                    }

                case 2:
                    System.out.println("---Consulta Individual---");
                    leer.nextLine();
                    System.out.print("Ingrese el nombre de la persona a consultar: ");
                    nombre = leer.nextLine();
                    p = ma.consultaIndividual(nombre);
                    if (p != null) {
                        System.out.println("Edad: " + p.getEdad());
                        System.out.println("Estatura: " + p.getEstatura());
                        System.out.print("Para continuar pulse Enter...");
                        leer.nextLine();
                    } else {
                        System.out.println("No existe esa persona en el archivo");
                        System.out.print("Para continuar pulse Enter...");
                        leer.nextLine();
                    }
                    break;
                case 3:
                    System.out.println("\n---Consulta General---");
                    ma.consultaGeneral();
                    System.out.print("Para continuar pulse Enter...");
                    leer.nextLine();
                    leer.nextLine();
                    break;
                case 4:
                    System.out.println("Programa Finalizado");
                    break;
                default:
                    System.out.println("\nOpcion no valida");
                    System.out.print("Para continuar pulse Enter...");
                    leer.nextLine();
                    leer.nextLine();
            }
        } while (opc != 4);
    }
}
