package com.greenbelly.need.ui.webapi;


import com.greenbelly.need.ui.enus.ModalidadeTrabalho;
import com.greenbelly.need.ui.model.CategoriaLoja;
import com.greenbelly.need.ui.model.Loja;
import com.greenbelly.need.ui.model.Pedido;
import com.greenbelly.need.ui.model.Produto;

import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class API {

    /**
     * URL fixa do portal.
     */
    public static final String BASE_URL = "https://192.168.0.10|zaswq21ZSAW21'zawq211''15:8080/";
    public static Retrofit retrofit;


    /**
     * Variavel geral para comunicação com o portal.
     */
//    private static Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();


    public static Retrofit getApiClient(){

        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getUnsafeOkHttpClient().build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

    public static OkHttpClient.Builder getUnsafeOkHttpClient() {

        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }





    public static void getCategoriasLojasProdutos(ModalidadeTrabalho modalidade, Callback< List<CategoriaLoja> > callback) {
        /* Cria o endpoint */
        EndPoint endpoint = getApiClient().create(EndPoint.class);

        // Variavel que armazena o retorno do HTTP:
        Call< List<CategoriaLoja> > call;

        HashMap<String, ModalidadeTrabalho> param = new HashMap();
        param.put("modalidade", modalidade);

        call = endpoint.getCategoriasLojas(param);
        call.enqueue(callback);
    }

    public static void getLojas(Long id, Callback< List<Loja> > callback) {
        /* Cria o endpoint */
        EndPoint endpoint = getApiClient().create(EndPoint.class);

        // Variavel que armazena o retorno do HTTP:
        Call< List<Loja> > call;

        HashMap<String, Long> param = new HashMap();
        param.put("id", id);

        call = endpoint.getLojas(param);
        call.enqueue(callback);
    }

    public static void getProdutosByLoja(Long id, Callback< List<Produto> > callback) {
        /* Cria o endpoint */
        EndPoint endpoint = getApiClient().create(EndPoint.class);

        // Variavel que armazena o retorno do HTTP:
        Call< List<Produto> > call;

        HashMap<String, Long> param = new HashMap();
        param.put("id", id);

        call = endpoint.getProdutosByLoja(param);
        call.enqueue(callback);
    }

    public static void getProdutosById(Long id, Callback< Produto > callback) {
        /* Cria o endpoint */
        EndPoint endpoint = getApiClient().create(EndPoint.class);

        // Variavel que armazena o retorno do HTTP:
        Call< Produto > call;

        call = endpoint.getProdutosById(id);
        call.enqueue(callback);
    }


    public static void getCategoriasLojasServicos(Callback< List<CategoriaLoja> > callback) {
        /* Cria o endpoint */
        EndPoint endpoint = getApiClient().create(EndPoint.class);

        // Variavel que armazena o retorno do HTTP:
        Call< List<CategoriaLoja> > call;

        HashMap<String, ModalidadeTrabalho> param = new HashMap();
        param.put("modalidade", ModalidadeTrabalho.PRESTADOR_SERVICOS);

        call = endpoint.getCategoriasLojas(param);
        call.enqueue(callback);
    }

    public static void gravarPedido(Pedido pedido, Callback<Pedido> callback) {
        EndPoint endpoint = retrofit.create(EndPoint.class);

        // Variavel que armazena o retorno do HTTP:
        Call<Pedido> call;

        HashMap<String, Pedido> param = new HashMap();
        param.put("pedido", pedido);

        /* Faz a chamada a utl, conforme tipo de registro. */
        call = endpoint.gravarPedido(param);
        call.enqueue(callback);
    }



//    public static void getProdutos(Callback< List<Produto> > callback) {
//        /* Cria o endpoint */
//        PedidosEndPoint endpoint = retrofit.create(PedidosEndPoint.class);
//
//        // Variavel que armazena o retorno do HTTP:
//        Call< List<Produto> > call;
//
//        call = endpoint.getProdutos();
//        call.enqueue(callback);
//    }
//
//    public static void getCategoriasProdutos(Callback< List<CategoriaProduto> > callback) {
//        /* Cria o endpoint */
//        PedidosEndPoint endpoint = retrofit.create(PedidosEndPoint.class);
//
//        // Variavel que armazena o retorno do HTTP:
//        Call< List<CategoriaProduto> > call;
//
//        call = endpoint.getCategoriasProdutos();
//        call.enqueue(callback);
//    }



    /**
     * Método responsável por buscar todos os clientes.
     */
//    public static void getClientesAll(Callback<List<Cliente>> callback) {
//
//        /* Cria o endpoint */
//        PedidosEndPoint endpoint = retrofit.create(PedidosEndPoint.class);
//
//        // Variavel que armazena o retorno do HTTP:
//        Call<List<Cliente>> call;
//
//        /* Faz a chamada a utl, conforme tipo de registro. */
//        call = endpoint.eventoBuscarTodos();
//        call.enqueue(callback);
//    }
//
//    public static void getPedidosAll(Callback<List<Pedido>> callback) {
//
//        /* Cria o endpoint */
//        PedidosEndPoint endpoint = retrofit.create(PedidosEndPoint.class);
//
//        // Variavel que armazena o retorno do HTTP:
//        Call<List<Pedido>> call;
//
//        /* Faz a chamada a utl, conforme tipo de registro. */
//        call = endpoint.pedidosBuscarTodos();
//        call.enqueue(callback);
//    }
//
//    public static void clienteAtualizar(Cliente cliente, Callback<Cliente> callback) {
//
//        /* Cria o endpoint */
//        PedidosEndPoint endpoint = retrofit.create(PedidosEndPoint.class);
//
//        // Variavel que armazena o retorno do HTTP:
//        Call<Cliente> call;
//
//        Gson gson = new Gson();
//
//        String clienteStr = gson.toJson(cliente);
//
//        HashMap<String, String> param = new HashMap();
//        param.put("cliente", clienteStr);
//
//        /* Faz a chamada a utl, conforme tipo de registro. */
//        call = endpoint.clienteAtualizar(param);
//        call.enqueue(callback);
//    }
//
//

//
//
//    public static void pedidoSincronizeUpload(Pedido pedido, Callback<Pedido> callback) {
//        System.out.println("%%%%%%%%%%%%%%%%%%% = " + pedido.toString());
//        /* Cria o endpoint */
//        PedidosEndPoint endpoint = retrofit.create(PedidosEndPoint.class);
//
//        // Variavel que armazena o retorno do HTTP:
//        Call<Pedido> call;
//
//        Gson gson = new Gson();
//
//
//        String pedidoStr = gson.toJson(pedido);
//
//        System.out.println("%%%%%%%JSON%%%%%%%%%%%% = " + pedidoStr);
//
//        HashMap<String, String> param = new HashMap();
//        param.put("pedido", pedidoStr);
//
//        /* Faz a chamada a utl, conforme tipo de registro. */
//        call = endpoint.sicronizePedidosUpload(param);
//        call.enqueue(callback);
//    }
//
//
//
//
//    /**
//     * Método responsável por buscar eventos especificos a partir de uma conta e tp_evento.
//     */
//    public static void eventoBuscarEspecificos(final String idConta, final String tp_evento, Callback<List<Cliente>> callback) {
//
//        /* Cria o endpoint */
//        PedidosEndPoint endpoint = retrofit.create(PedidosEndPoint.class);
//
//        // Variavel que armazena o retorno do HTTP:
//        Call<List<Cliente>> call;
//
//        HashMap<String, String> param = new HashMap();
//        param.put("idConta", idConta);
//        param.put("tp_evento", tp_evento);
//
//        /* Faz a chamada a utl, conforme tipo de registro. */
//        call = endpoint.eventoBuscarEspecifico(param);
//        call.enqueue(callback);
//    }
//
//    public static void eventosInserir(int idConta, Cliente cliente, Callback<Resposta> callback) {
//        /* Cria o endpoint */
//        PedidosEndPoint endpoint = retrofit.create(PedidosEndPoint.class);
//
//        // Variavel que armazena o retorno do HTTP:
//        Call<Resposta> call;
//
//        /* Faz a chamada a utl, conforme tipo de registro. */
//        call = endpoint.eventoInserir(cliente);
//        call.enqueue(callback);
//    }

}

