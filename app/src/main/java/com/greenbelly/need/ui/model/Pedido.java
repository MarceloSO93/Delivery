package com.greenbelly.need.ui.model;

import com.greenbelly.need.ui.enus.StatusCobranca;
import com.greenbelly.need.ui.enus.StatusPedido;
import com.greenbelly.need.ui.enus.TipoPagamento;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Pedido {

    private Long id;
    private BigDecimal valor;
    private StatusPedido statusPedido;
    private Date dataAbertura;
    private Date dataFechamento;
    private StatusCobranca statusCobranca;
    private TipoPagamento tipoPagamento;
    private Cliente cliente;
    private Loja loja;
    private Endereco enderecoEntrega;
    private com.greenbelly.need.ui.model.Entregador Entregador;
    private List<Produto> produtos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public StatusCobranca getStatusCobranca() {
        return statusCobranca;
    }

    public void setStatusCobranca(StatusCobranca statusCobranca) {
        this.statusCobranca = statusCobranca;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public com.greenbelly.need.ui.model.Entregador getEntregador() {
        return Entregador;
    }

    public void setEntregador(com.greenbelly.need.ui.model.Entregador entregador) {
        Entregador = entregador;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
