package com.cajero.model.strategy;

public class RetiroNormalStrategy implements RetiroStrategy {
    @Override
    public double montoADescontar(double saldoActual, double cantidad) {
        if (cantidad <= 0) {
            return -1; // no permite retiros no positivos
        }
        return (cantidad <= saldoActual) ? cantidad : -1;
    }
}
