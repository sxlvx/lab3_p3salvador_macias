package com.mycompany.lab3p2_salvadormacias;

import java.util.Scanner;
import java.util.ArrayList;

public class Lab3p2_salvadormacias {

    static Scanner lea = new Scanner(System.in);
    static ArrayList<Object> lista = new ArrayList();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("---Bienvenido al sistema de inventario---");
        int opcion;
        boolean salida = false;
        do {
            System.out.println("---MENU---\n"
                    + "1.Agregar Comida\n2.Agregar bebida\n3.Modificar productos\n4.Eliminar producto\n5.Mostrar productos\n6.Generar compra\n7.Registro de Compras\n8.Salir");
            System.out.println("Ingrese opcion: ");
            opcion = lea.nextInt();
            lea.nextLine();
            switch (opcion) {
                case 1: {
                    agregarComida();
                    break;
                }
                case 2: {
                    agregarBebida();
                    break;
                }
                case 3: {
                    System.out.println("modificar bebidas o comidas\n");
                    System.out.println("1.comidas\n2.bebidas\n");
                    System.out.println("Ingrese opcion: ");
                    int op = lea.nextInt();
                    lea.nextLine();
                    switch (op) {
                        case 1: {
                            modComida();
                            break;
                        }
                        case 2: {
                            modBebida();
                            break;
                        }
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }
                    break;
                }
                case 4: {
                    System.out.println("eliminar bebidas o comidas\n");
                    System.out.println("1.comidas\n2.bebidas\n");
                    System.out.println("Ingrese opcion: ");
                    int op = lea.nextInt();
                    eliminar(op);
                }
                case 5: {
                    System.out.println("Comidas en el inventario: \n");
                    listarComidas();
                    System.out.println("Bebidas en el inventario: \n");
                    listarBebidas();
                    break;
                }
                case 6: {
                    int total = 0;
                    char resp;
                    Compras compras = new Compras();

                    do {
                        System.out.println("Comidas disponibles a comprar:\n");
                        listarComidas();
                        System.out.println("Bebidas disponibles a comprar:\n");
                        listarBebidas();

                        System.out.println("Ingrese el indice del producto que desea comprar: ");
                        int index = lea.nextInt();
                        System.out.println("Ingrese la cantidad del producto que desea comprar: ");
                        int cant = lea.nextInt();
                        lea.nextLine();
                        if (cant > 0) {
                            if (lista.get(index) instanceof Comidas) {
                                total += ((Comidas) lista.get(index)).getPrecio() * cant;
                                compras.getCompras().add(lista.get(index));
                                compras.getCompras().add(cant);
                            } else if (lista.get(index) instanceof Bebidas) {
                                total += ((Bebidas) lista.get(index)).getPrecio() * cant;
                                compras.getCompras().add(lista.get(index));
                                compras.getCompras().add(cant);
                            } else {
                                System.out.println("Indice ingresado es invalido");
                            }
                        } else {
                            System.out.println("La cantidad debe ser mayor a cero");
                        }

                        System.out.println("Desea comprar otro producto [S/N]: ");
                        resp = lea.nextLine().charAt(0);
                    } while (resp == 's')||(resp == 'S'
                    );

                    compras.setTotal(total);
                    lista.add(compras);
                    System.out.println(compras);
                    break;
                }
                case 7: {
                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i) instanceof Compras) {
                            System.out.println((Compras) lista.get(i));
                        }
                    }
                    break;
                }
                case 8: {
                    System.out.println("Se abandonara el programa");
                    salida = true;
                    break;
                }
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (salida != true);
    }//fin menu

    public static void listarComidas() {
        int i = 0;
        while (i < lista.size()) {
            if (lista.get(i) instanceof Comidas) {
                System.out.println(i + lista.get(i));
            }
            i++;
        }
    }//fin listar comidas

    public static void listarBebidas() {
        int i = 0;
        while (i < lista.size()) {
            if (lista.get(i) instanceof Bebidas) {
                System.out.println(i  + lista.get(i));
            }
            i++;
        }
    }//fin listar bebidas

    public static void agregarComida() {
        System.out.println("Ingrese nombre de la comida: ");
        String nombre = lea.nextLine();
        System.out.println("Ingrese precio: ");
        double precio = lea.nextDouble();
        if (precio <= 0) {
            System.out.println("El precio debe ser mayor a 0");
        } else {
            System.out.println("Ingrese el estado de la comida:"
                    + "\n0-Vencido\n1-Comestible");
            int estado_fu = lea.nextInt();
            boolean estado;
            switch (estado_fu) {
                case 0: {
                    estado = false;
                    Comidas comida = new Comidas(estado, precio, nombre);
                    lista.add(comida);
                    break;
                }
                case 1: {
                    estado = true;
                    Comidas comida = new Comidas(estado, precio, nombre);
                    lista.add(comida);
                    break;
                }
                default:
                    System.out.println("Opcion ingresada es valida");
                    break;
            }

        }
    }//fin agregar comida

    public static void agregarBebida() {
        System.out.println("Ingrese nombre de la bebida: ");
        String nombre = lea.nextLine();
        System.out.println("Ingrese precio: ");
        double precio = lea.nextDouble();
        if (precio <= 0) {
            System.out.println("El precio debe ser mayor a 0");
        } else {
            System.out.println("Ingrese el tamano en milimetros: ");
            int tam = lea.nextInt();
            if (tam > 0) {
                Bebidas bebida = new Bebidas(tam, precio, nombre);
                lista.add(bebida);
            } else {
                System.out.println("El tamano ingresado debe ser mayor a 0");
            }
        }

    }//fin agregar bebida

    public static void modComida() {
        listarComidas();
        System.out.println("Ingrese el indice que sera modificada: ");
        int index = lea.nextInt();
        lea.nextLine();
        System.out.println("modificaciones disponibles:\n"
                + "1.Nombre\n2.Precio\n3.Estado\nIngrese la modificacion que desea realizar");
        int modi_fu = lea.nextInt();
        switch (modi_fu) {
            case 1: {
                lea.nextLine();
                System.out.println("Ingrese nombre de la comida: ");
                String nombre = lea.nextLine();
                ((Comidas) lista.get(index)).setNombre(nombre);
                break;
            }
            case 2: {
                System.out.println("Ingrese el precio: ");
                double precio = lea.nextDouble();
                if (precio >= 0) {
                    ((Comidas) lista.get(index)).setPrecio(precio);
                } else {
                    System.out.println("El precio debe ser mayor a 0");
                }
                break;
            }
            case 3: {
                System.out.println("Ingrese el estado de la comida:"
                        + "\n0-Vencido\n1-Comestible");
                int a = lea.nextInt();
                boolean estado;
                switch (a) {
                    case 0: {
                        estado = false;
                        ((Comidas) lista.get(index)).setEstado(estado);;
                        break;
                    }
                    case 1: {
                        estado = true;
                        ((Comidas) lista.get(index)).setEstado(estado);
                        break;
                    }
                    default:
                        System.out.println("Opcion ingresada es valida");
                        break;
                }
                break;
            }
            default:
                System.out.println("Opcion ingresada es valida");
                break;
        }

    }//fin modificacion comida

    public static void modBebida() {
        listarBebidas();
        System.out.println("Ingrese el indice que sera modificada: ");
        int index = lea.nextInt();
        lea.nextLine();
        System.out.println("modificaciones disponibles:\n"
                + "1.Nombre\n2.Precio\n3.Tamano\nIngrese la modificacion que desea realizar");

        int modi = lea.nextInt();
        switch (modi) {
            case 1: {
                System.out.println("Ingrese el nombre de la bebida que desea modificar: ");
                String nombre = lea.nextLine();
                ((Bebidas) lista.get(index)).setNombre(nombre);
                break;
            }
            case 2: {
                System.out.println("Ingrese precio: ");
                double precio = lea.nextDouble();
                if (precio >= 0) {
                    ((Bebidas) lista.get(index)).setPrecio(precio);
                } else {
                    System.out.println("El precio debe ser mayor a 0");
                }
                break;
            }
            case 3: {
                System.out.println("Ingrese tamano en milimetros: ");
                int tam = lea.nextInt();
                if (tam > 0) {
                    ((Bebidas) lista.get(index)).setTam(tam);
                } else {
                    System.out.println("Numero ingresado es invalido");
                }
                break;
            }
            default:
                System.out.println("Opcion ingresada es valida");
                break;
        }
    }//modificar bebida

    public static void eliminar(int i) {
        switch (i) {
            case 1: {
                listarComidas();
                System.out.println("Ingrese el indice de la comida que desea eliminar: ");
                int index = lea.nextInt();
                lista.remove(index);
                System.out.println("comida eliminada exitosamente ");
                break;
            }
            case 2: {
                listarBebidas();
                System.out.println("Ingrese el indice de la bebida a eliminar: ");
                int index = lea.nextInt();
                lista.remove(index);
                System.out.println("bebida eliminada exitosamente");
                break;
            }
            default:
                System.out.println("Opcion ingresada es invalida");
                break;
        }
    }//eliminar comidas o bebidas

}//fin clase
