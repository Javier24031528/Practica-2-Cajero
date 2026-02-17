package com.cajero.main;

import com.cajero.controller.CajeroControlador;
import com.cajero.view.CajeroVista;

public class Main {
    public static void main(String[] args) {
        // Creamos el controlador y la vista
        CajeroControlador control = new CajeroControlador();
        CajeroVista view = new CajeroVista();

        view.mostrarMensaje("=== Bienvenido al Cajero (MVC) ===");

        int intentos = 0;
        boolean entro = false; // flag para saber si entro al sistema

        // Ciclo para pedir el PIN maximo 3 veces
        while (intentos < 3 && entro == false) {
            String p = view.leerPin();
            if (control.validarPin(p)) {
                entro = true;
            } else {
                view.mostrarMensaje("PIN incorrecto.");
                intentos = intentos + 1; // contador de intentos
            }
        }

        if (entro == false) {
            view.mostrarMensaje("Demasiados intentos fallidos. Adiós.");
            return;
        }

        view.mostrarMensaje("Bienvenido, " + control.getUsuarioActual().getNombre());

        boolean s = false; // s de salir
        while (s == false) {
            int opc = view.mostrarMenu();

            if (opc == 1) {
                view.mostrarMensaje("Su saldo es: $" + control.consultarSaldo());
            } else if (opc == 2) {
                double cantRetiro = view.leerCantidad("retirar");
                if (control.realizarRetiro(cantRetiro)) {
                    view.mostrarMensaje("Retiro exitoso. Nuevo saldo: $" + control.consultarSaldo());
                } else {
                    view.mostrarMensaje("Fondos insuficientes.");
                }
            } else if (opc == 3) {
                double cantDeposito = view.leerCantidad("depositar");
                control.realizarDeposito(cantDeposito);
                view.mostrarMensaje("Depósito exitoso. Nuevo saldo: $" + control.consultarSaldo());
            } else if (opc == 4) {
                s = true;
                view.mostrarMensaje("Gracias por usar el cajero.");
            } else {
                view.mostrarMensaje("Opción inválida.");
            }
        }
    }
}