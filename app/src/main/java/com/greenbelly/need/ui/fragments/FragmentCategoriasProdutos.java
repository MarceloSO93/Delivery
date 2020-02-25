package com.greenbelly.need.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.greenbelly.need.R;
import com.greenbelly.need.ui.adapters.ReciclerViewCategoriaLojasAdapter;
import com.greenbelly.need.ui.enus.ModalidadeTrabalho;
import com.greenbelly.need.ui.model.CategoriaLoja;
import com.greenbelly.need.ui.services.CategoriaService;
import com.greenbelly.need.ui.webapi.SimpleCallback;

import java.util.ArrayList;
import java.util.List;

public class FragmentCategoriasProdutos extends Fragment {

    private RecyclerView reciclerViewCategorias;

//    public static FloatingActionButton floatingActionButton;

    private static ReciclerViewCategoriaLojasAdapter reciclerViewCategoriasAdapter;

    private List<CategoriaLoja> categorias = new ArrayList<>();

    private View rootView;

    public FragmentCategoriasProdutos() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_categorias, container, false);

        inicializaComponentes(rootView);
        listar(container);

        return rootView;
    }


    public static ReciclerViewCategoriaLojasAdapter getListReciclerViewCategoriaLojasAdapter() {
        return reciclerViewCategoriasAdapter;
    }

    private void listar(final ViewGroup container) {
        reciclerViewCategorias.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        reciclerViewCategorias.setLayoutManager(linearLayoutManager);

        CategoriaService.getCategoriasLojas(ModalidadeTrabalho.VENDAS_PRODUTOS, new SimpleCallback<List<CategoriaLoja>>() {
            @Override
            public void onResponse(List<CategoriaLoja> response) {
                categorias = response;

                reciclerViewCategoriasAdapter = new ReciclerViewCategoriaLojasAdapter(categorias);
                reciclerViewCategorias.setLayoutManager(new GridLayoutManager(container.getContext(),2));
                reciclerViewCategorias.setAdapter(reciclerViewCategoriasAdapter);
            }

            @Override
            public void onError(String error) {
                Toast.makeText(container.getContext(), "erro onError: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void inicializaComponentes(View rootView) {
        reciclerViewCategorias = rootView.findViewById(R.id.reciclerViewCategoriaProdutos);
//        floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.floatingActionButton_addpedido_agua);
//        floatingActionButton.setVisibility(View.GONE);
    }

//
//    @Override
//    public void onResume() {
//        super.onResume();
//
//        List<Produto> pdts = ControleProdutos.getAguaProdutosList();
//
//        if (pdts.size() > 0) {
//
//            reciclerViewCategoriasAdapter = new ReciclerViewAguaProdutosAdapter(pdts);
//            reciclerViewAguaProdutos.setAdapter(reciclerViewCategoriasAdapter);
//
//        } else {
//            Toast.makeText(this.getContext(), "Não foi possível popular lista de agua", Toast.LENGTH_SHORT).show();
//        }
//    }
}
