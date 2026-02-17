package com.cajero.controller;

import com.cajero.model.Usuario;
import java.util.ArrayList;

public class CajeroControlador {
    // Lista para guardar usuarios
    private ArrayList<Usuario> usuarios;
    private Usuario usuarioActual;

    public CajeroControlador() {
        usuarios = new ArrayList<Usuario>(); // Especificando el tipo
        // Datos iniciales
        Usuario u1 = new Usuario("1234", "Juan", 1000.0);
        Usuario u2 = new Usuario("5678", "Maria", 2500.0);
        usuarios.add(u1);
        usuarios.add(u2);
    }

    public boolean validarPin(String pin) {
        for (Usuario u : usuarios) {
            if (u.getPin().equals(pin)) {
                usuarioActual = u;
                return true; // si lo encuentra
            }
        }
        return false; // no lo encontro
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public double consultarSaldo() {
        return usuarioActual.getSaldo();
    }

    public boolean realizarRetiro(double cant) {
        // llama al metodo del modelo
        return usuarioActual.retirar(cant);
    }

    public void realizarDeposito(double cant) {
        // llama al metodo del modelo
        usuarioActual.depositar(cant);
    }
}