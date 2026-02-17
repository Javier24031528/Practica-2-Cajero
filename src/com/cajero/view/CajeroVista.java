package com.cajero.view;

import java.util.Scanner;

public class CajeroVista {

    private Scanner scanner;

    public CajeroVista() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMensaje(String m) {
        System.out.println(m);
    }

    public String leerPin() {
        System.out.print("Ingrese su PIN: ");
        String p = scanner.nextLine();
        return p;
    }

    public int mostrarMenu() {
        System.out.println("\n--- MENU DE OPCIONES ---");
        System.out.println("1. Ver saldo");
        System.out.println("2. Retirar dinero");
        System.out.println("3. Depositar dinero");
        System.out.println("4. Salir");
        System.out.print("Escriba el numero de la opcion: ");
        int op = scanner.nextInt();
        scanner.nextLine();
        return op;
    }

    public double leerCantidad(String accion) {
        System.out.print("¿Cuanto desea " + accion + "?: ");
        double cant = scanner.nextDouble();
        scanner.nextLine(); 
        return cant;
    }
}