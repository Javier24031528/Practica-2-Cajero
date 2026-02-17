package com.cajero.model;

public class Usuario {

    private String pin;
    private String nombre;
    private double saldo;

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

    public void depositar(double cantidad) {
        this.saldo = this.saldo + cantidad;
    }

    public boolean retirar(double cantidad) {
        if (cantidad <= saldo) {
            this.saldo = this.saldo - cantidad;
            return true;
        } else {
            return false;
        }
    }
}