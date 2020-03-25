package com.greenbelly.need.ui.enus;

public enum StatusCobranca {

    PAGO(1), PENDENTE(2), CANCELADA(3);

    private int value;

    StatusCobranca(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
