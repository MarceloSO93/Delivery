package com.greenbelly.need.ui.services;

import com.greenbelly.need.ui.model.Produto;
import com.greenbelly.need.ui.webapi.API;
import com.greenbelly.need.ui.webapi.SimpleCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProdutosService {


    public static void getProdutosByLoja(Long id, final SimpleCallback<List<Produto>> callback) {

        API.getProdutosByLoja(id, new Callback<List<Produto>>() {

            @Override
            public void onResponse(Call<List<Produto>> call, Response<List<Produto>> response) {

                if (response.isSuccessful() && response.body() != null) {
                    callback.onResponse(response.body());
                } else {
                    if (response.body() != null) {
                        callback.onError("erro");
                    } else {
                        callback.onError("erro");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Produto>> call, Throwable t) {
                t.printStackTrace();
                callback.onError(t.getMessage());
            }
        });
    }


    public static void getProdutosById(Long id, final SimpleCallback<Produto> callback) {

        API.getProdutosById(id, new Callback<Produto>() {

            @Override
            public void onResponse(Call<Produto> call, Response<Produto> response) {

                if (response.isSuccessful() && response.body() != null) {
                    callback.onResponse(response.body());
                } else {
                    if (response.body() != null) {
                        callback.onError("erro");
                    } else {
                        callback.onError("erro");
                    }
                }
            }

            @Override
            public void onFailure(Call<Produto> call, Throwable t) {
                t.printStackTrace();
                callback.onError(t.getMessage());
            }
        });
    }

}
