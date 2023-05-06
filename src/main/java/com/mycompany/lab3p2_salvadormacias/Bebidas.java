package com.mycompany.lab3p2_salvadormacias;

public class Bebidas extends Productos{
    
    private int tamano;

    public Bebidas(int tamano, double precio, String nombre) {
        super(precio, nombre);
        this.tamano = tamano;
    }

    public int getTam() {
        return tamano;
    }

    public void setTam(int tam) {
        this.tamano = tam;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Bebidas{" + "tam=" + tamano + super.toString() + '}';
    }
}
    
