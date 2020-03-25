package com.greenbelly.need.ui.webapi;


import com.greenbelly.need.ui.enus.ModalidadeTrabalho;
import com.greenbelly.need.ui.model.CategoriaLoja;
import com.greenbelly.need.ui.model.Loja;
import com.greenbelly.need.ui.model.Pedido;
import com.greenbelly.need.ui.model.Produto;
import com.greenbelly.need.ui.model.Entregador;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface EndPoint {

    //    @GET("webgas/webresources/gas/clientes/get_list")
//    Call<List<Cliente>> eventoBuscarTodos();
//
//    @GET("webgas/webresources/gas/pedidos/get_list")
//    Call<List<Pedido>> pedidosBuscarTodos();
//
    @GET("webgas/webresources/gas/cliente/update")
    Call<Entregador> clienteAtualizar(@QueryMap Map<String, String> params);


    //    @POST("webserviceappgasja/webresources/webgas/add/pedido")
//    Call<Pedido> addPedido(@Body Pedido pedido);
    @GET("categorias-lojas/modalidade/")
    Call<List<CategoriaLoja>> getCategoriasLojas(@QueryMap Map<String, ModalidadeTrabalho> params);

    @GET("loja/categoria/")
    Call<List<Loja>> getLojas(@QueryMap Map<String, Long> params);

    @GET("produto/find-by-loja/")
    Call<List<Produto>> getProdutosByLoja(@QueryMap Map<String, Long> params);

    @GET("produto/{id}")
    Call<Produto> getProdutosById(@Path("id") Long id);

    @POST("pedido/")
    Call<Pedido> gravarPedido(@QueryMap Map<String, Pedido> params);

//    @GET("webserviceappgasja/webresources/webgas/get/produtos")
//    Call<List<Produto>> getProdutos();

//    @GET("webserviceappgasja/webresources/webgas/get/categorias_produtos")
//    Call<List<CategoriaProduto>> getCategoriasProdutos();
//
//    @GET("api/gas/getclientes/especifico")
//    Call<List<Cliente>> eventoBuscarEspecifico(@QueryMap Map<String, String> params);
//
//    @POST("api/unesc/eventoinserir")
//    Call<Resposta> eventoInserir(@Body Cliente evento);

}
