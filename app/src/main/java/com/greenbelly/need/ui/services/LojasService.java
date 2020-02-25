package com.greenbelly.need.ui.services;

import com.greenbelly.need.ui.model.Loja;
import com.greenbelly.need.ui.webapi.API;
import com.greenbelly.need.ui.webapi.SimpleCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LojasService {


    public static void getLojas(Long id, final SimpleCallback<List<Loja>> callback) {

        API.getLojas(id, new Callback<List<Loja>>() {

            @Override
            public void onResponse(Call<List<Loja>> call, Response<List<Loja>> response) {

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
            public void onFailure(Call<List<Loja>> call, Throwable t) {
                t.printStackTrace();
                callback.onError(t.getMessage());
            }
        });
    }

}
