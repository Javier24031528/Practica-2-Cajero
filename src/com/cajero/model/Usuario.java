package com.cajero.model;

import com.cajero.model.strategy.RetiroNormalStrategy;
import com.cajero.model.strategy.RetiroStrategy;

public class Usuario {

    private String pin;
    private String nombre;
    private double saldo;
    private RetiroStrategy retiroStrategy;

    public Usuario(String pin, String nombre, double saldo) {
        this.pin = pin;
        this.nombre = nombre;
        this.saldo = saldo;
        // Estrategia por defecto: retiro normal sin comisiones
        this.retiroStrategy = new RetiroNormalStrategy();
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

    public void setRetiroStrategy(RetiroStrategy retiroStrategy) {
        this.retiroStrategy = retiroStrategy;
    }

    public RetiroStrategy getRetiroStrategy() {
        return retiroStrategy;
    }

    public void depositar(double cantidad) {
        this.saldo = this.saldo + cantidad;
    }

    public boolean retirar(double cantidad) {
        double montoADescontar = retiroStrategy.montoADescontar(this.saldo, cantidad);
        if (montoADescontar >= 0 && montoADescontar <= this.saldo) {
            this.saldo = this.saldo - montoADescontar;
            return true;
        } else {
            return false;
        }
    }
}