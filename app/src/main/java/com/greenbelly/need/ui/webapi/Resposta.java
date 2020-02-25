package com.greenbelly.need.ui.webapi;

public class Resposta {
    private boolean sucesso;
    private String mensagem;
    private Long dados;

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Long getDados() {
        return dados;
    }

    public void setDados(Long dados) {
        this.dados = dados;
    }
}
