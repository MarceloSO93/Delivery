package com.greenbelly.need.ui.model;

import com.greenbelly.need.ui.enus.ModalidadeTrabalho;

import java.io.Serializable;

public class CategoriaLoja implements Serializable {

    private Long id;
    private String nome;
    private boolean privado;
    private ModalidadeTrabalho modalidadeTrabalho;
    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isPrivado() {
        return privado;
    }

    public void setPrivado(boolean privado) {
        this.privado = privado;
    }

    public ModalidadeTrabalho getModalidadeTrabalho() {
        return modalidadeTrabalho;
    }

    public void setModalidadeTrabalho(ModalidadeTrabalho modalidadeTrabalho) {
        this.modalidadeTrabalho = modalidadeTrabalho;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
