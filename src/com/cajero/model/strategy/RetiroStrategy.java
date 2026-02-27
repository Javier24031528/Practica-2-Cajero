package com.cajero.model.strategy;

public interface RetiroStrategy {
    /**
     * Calcula el monto total a descontar del saldo para realizar el retiro.
     * Si el retiro no es posible, devolver un valor negativo (por ejemplo, -1).
     *
     * @param saldoActual Saldo disponible en la cuenta del usuario
     * @param cantidad Cantidad solicitada para retirar
     * @return Monto total a descontar (incluyendo posibles comisiones). Valor negativo si no procede el retiro.
     */
    double montoADescontar(double saldoActual, double cantidad);
}
