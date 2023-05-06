package com.mycompany.lab3p2_salvadormacias;

import java.util.ArrayList;

public class Compras {

    private double total;
    private ArrayList compras = new ArrayList();

    public Compras() {
    }

    public Compras(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList getCompras() {
        return compras;
    }

    public void setCompras(ArrayList compras) {
        this.compras = compras;
    }

    @Override
    public String toString() {
        return "Compras{" + "total=" + total + ", compras=\n" + compras + '}';
    }

    public void imprimirArreglo() {
        for (int i = 0; i < compras.size(); i++) {
            System.out.println(i + " <-" + compras.get(i));
        }

    }
}
