package com.greenbelly.need.ui.model;

import java.util.List;

public class Loja {

    private Long id;
    private String nome;
    private String telefone;
    private boolean online;
    private CategoriaLoja categoriaLoja;
    private Entregador responsavel;
    private Endereco endereco;
    private List<Entregador> entregadors;
    private List<Produto> produtos;
    private String logo;

    public Loja(String nome, String telefone, boolean online) {
        this.nome = nome;
        this.telefone = telefone;
        this.online = online;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public CategoriaLoja getCategoriaLoja() {
        return categoriaLoja;
    }

    public void setCategoriaLoja(CategoriaLoja categoriaLoja) {
        this.categoriaLoja = categoriaLoja;
    }

    public Entregador getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Entregador responsavel) {
        this.responsavel = responsavel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Entregador> getEntregadors() {
        return entregadors;
    }

    public void setEntregadors(List<Entregador> entregadors) {
        this.entregadors = entregadors;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
