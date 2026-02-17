package com.cajero.model;

public class Usuario {
    // Atributos del usuario
    private String pin;
    private String nombre;
    private double saldo;

    // Constructor para crear usuario
    public Usuario(String pin, String nombre, double saldo) {
        this.pin = pin;
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getPin() {
        return pin;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    // Metodo para depositar dinero
    public void depositar(double cantidad) {
        // System.out.println("DEBUG: depositando " + cantidad);
        this.saldo = this.saldo + cantidad; // mas simple
    }

    // Metodo para retirar dinero
    public boolean retirar(double cantidad) {
        if (cantidad <= saldo) {
            this.saldo = this.saldo - cantidad; // usando resta normal
            return true;
        } else {
            return false;
        }
    }
}