package com.greenbelly.need.ui.enus;

public enum  TipoUsuario {

    RESPONSAVEL(1), ADMINISTRADOR(2), ENTREGADOR(3), ATENDENTE(4);

    private int value;

    TipoUsuario(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
