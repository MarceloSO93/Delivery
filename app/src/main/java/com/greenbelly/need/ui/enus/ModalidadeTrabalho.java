package com.greenbelly.need.ui.enus;

public enum ModalidadeTrabalho {

    VENDAS_PRODUTOS(1, "Produtos"),
    PRESTADOR_SERVICOS(2, "Serviços"),
    LOCACAO_BENS(3, "Locação");

    private int value;
    private String description;

    ModalidadeTrabalho(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
