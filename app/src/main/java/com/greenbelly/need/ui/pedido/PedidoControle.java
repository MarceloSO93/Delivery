package com.greenbelly.need.ui.pedido;

import com.greenbelly.need.ui.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoControle {

    private static List<Pedido> pedidos = new ArrayList();

    private static PedidoControle instance = new PedidoControle();

    private PedidoControle() {
    }

    public static PedidoControle getInstance() {return instance;};

    public static List<Pedido> getPedidos() {return pedidos;};

    public boolean addPedido(Pedido pedido){
        return pedidos.add(pedido);
    }


    public boolean efetuarPedido() {return true;};

}
