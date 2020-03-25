package com.greenbelly.need.ui.activits;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.greenbelly.need.R;
import com.greenbelly.need.ui.adapters.ReciclerViewProdutosLojaAdapter;
import com.greenbelly.need.ui.model.Pedido;
import com.greenbelly.need.ui.model.Produto;
import com.greenbelly.need.ui.services.ProdutosService;
import com.greenbelly.need.ui.webapi.SimpleCallback;

import java.util.ArrayList;
import java.util.List;

public class ProdutosLojaActivity extends AppCompatActivity {

    private RecyclerView reciclerViewProdutosLoja;
    private static ReciclerViewProdutosLojaAdapter reciclerViewProdutosLojaAdapter;
    private List<Produto> produtos = new ArrayList<>();
    private Long lojaId;

    private Pedido pedido;
    private List<Produto> produtosSelecionados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos_loja);

        Intent intent = getIntent(); // gets the previously created intent
        lojaId = intent.getLongExtra("lojaId", 0L);

        listar(this, lojaId);
    }

    public static ReciclerViewProdutosLojaAdapter getListReciclerViewProdutosLojaAdapter() {
        return reciclerViewProdutosLojaAdapter;
    }

    private void listar(final Context contex, Long lojaId) {
        reciclerViewProdutosLoja = (RecyclerView) ProdutosLojaActivity.this.findViewById(R.id.reciclerViewProdutosLoja);
        reciclerViewProdutosLoja.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(contex);
        reciclerViewProdutosLoja.setLayoutManager(linearLayoutManager);

        ProdutosService.getProdutosByLoja(lojaId, new SimpleCallback<List<Produto>>() {
            @Override
            public void onResponse(List<Produto> response) {
                produtos = response;

                reciclerViewProdutosLojaAdapter = new ReciclerViewProdutosLojaAdapter(produtos);
                reciclerViewProdutosLoja.setAdapter(getListReciclerViewProdutosLojaAdapter());
            }

            @Override
            public void onError(String error) {
                Toast.makeText(contex, "erro onError: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
}