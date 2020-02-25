package com.greenbelly.need.ui.activits;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.greenbelly.need.R;
import com.greenbelly.need.ui.adapters.ReciclerViewLojasAdapter;
import com.greenbelly.need.ui.model.Loja;
import com.greenbelly.need.ui.services.LojasService;
import com.greenbelly.need.ui.webapi.SimpleCallback;

import java.util.ArrayList;
import java.util.List;

public class LojasActivity extends AppCompatActivity {

    private RecyclerView reciclerViewCategoriasProdutos;
    private static ReciclerViewLojasAdapter reciclerViewCategoriasProdutosAdapter;
    private List<Loja> categorias = new ArrayList<>();
    private Long categoriaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lojas);

        Intent intent = getIntent(); // gets the previously created intent
        categoriaId = intent.getLongExtra("categoriaId", 0L);

        listar(this, categoriaId);
    }

    public static ReciclerViewLojasAdapter getListReciclerViewLojasAdapter() {
        return reciclerViewCategoriasProdutosAdapter;
    }

    private void listar(final Context contex, Long categoriaId) {
        reciclerViewCategoriasProdutos = (RecyclerView) LojasActivity.this.findViewById(R.id.reciclerViewLojas);
        reciclerViewCategoriasProdutos.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(contex);
        reciclerViewCategoriasProdutos.setLayoutManager(linearLayoutManager);

        LojasService.getLojas(categoriaId, new SimpleCallback<List<Loja>>() {
            @Override
            public void onResponse(List<Loja> response) {
                categorias = response;

                reciclerViewCategoriasProdutosAdapter = new ReciclerViewLojasAdapter(categorias);
                reciclerViewCategoriasProdutos.setLayoutManager(new GridLayoutManager(contex,1));
                reciclerViewCategoriasProdutos.setAdapter(getListReciclerViewLojasAdapter());
            }

            @Override
            public void onError(String error) {
                Toast.makeText(contex, "erro onError: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}