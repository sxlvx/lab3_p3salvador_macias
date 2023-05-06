package com.mycompany.lab3p2_salvadormacias;

public class Comidas extends Productos {

    private boolean estado;

    public Comidas(boolean estado, double precio, String nombre) {
        super(precio, nombre);
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
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
        return "Comidas{" + "estado=" + estado + super.toString() + '}';
    }

}
