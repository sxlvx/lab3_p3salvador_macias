package com.mycompany.lab3p2_salvadormacias;

public class Productos {

    protected double precio;
    protected String nombre;

    public Productos(double precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
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
        return "Productos{" + "precio=" + precio + ", nombre=" + nombre + '}';
    }

}
