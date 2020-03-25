package com.greenbelly.need.ui.enus;

public enum StatusPedido {

    ABERTO(1), ACEIT0(2), EM_TRANSITO(3), CONCLUIDO(4), CANCELADO(5);

    private int value;

    StatusPedido(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
