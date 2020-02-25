package com.greenbelly.need.ui.services;

import com.greenbelly.need.ui.enus.ModalidadeTrabalho;
import com.greenbelly.need.ui.model.CategoriaLoja;
import com.greenbelly.need.ui.webapi.API;
import com.greenbelly.need.ui.webapi.SimpleCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriaService {


    public static void getCategoriasLojas(ModalidadeTrabalho modalidade, final SimpleCallback<List<CategoriaLoja>> callback) {

        API.getCategoriasLojasProdutos(modalidade, new Callback<List<CategoriaLoja>>() {

            @Override
            public void onResponse(Call<List<CategoriaLoja>> call, Response<List<CategoriaLoja>> response) {

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
            public void onFailure(Call<List<CategoriaLoja>> call, Throwable t) {
                t.printStackTrace();
                callback.onError(t.getMessage());
            }
        });
    }

}
