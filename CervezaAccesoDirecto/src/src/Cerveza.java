/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author Geraf
 */
public class Cerveza {
    private int clave;
    private String nombre;
    private float precio;
    private char tipo;
    private float volAlcohol;

    public Cerveza(int clave, String nombre, float precio, char tipo, float volAlcohol) {
        this.clave = clave;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.volAlcohol = volAlcohol;
    }

    public float getVolAlcohol() {
        return volAlcohol;
    }

    public void setVolAlcohol(float volAlcohol) {
        this.volAlcohol = volAlcohol;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }
    
    
}
