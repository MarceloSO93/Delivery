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

public class FragmentCategoriasLocacao extends Fragment {

    private RecyclerView reciclerViewCategoriasProdutos;
    private List<CategoriaLoja> categorias = new ArrayList<>();

    private static ReciclerViewCategoriaLojasAdapter reciclerViewCategoriasProdutosAdapter;


    private View rootView;

    public FragmentCategoriasLocacao() {
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
        populaLista(container);

        return rootView;
    }


    public static ReciclerViewCategoriaLojasAdapter getListReciclerViewCategoriaLojasAdapter() {
        return reciclerViewCategoriasProdutosAdapter;
    }

    private void populaLista(final ViewGroup container) {
        reciclerViewCategoriasProdutos.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(container.getContext());
        reciclerViewCategoriasProdutos.setLayoutManager(linearLayoutManager);

        CategoriaService.getCategoriasLojas(ModalidadeTrabalho.LOCACAO_BENS, new SimpleCallback<List<CategoriaLoja>>() {
            @Override
            public void onResponse(List<CategoriaLoja> response) {
                categorias = response;

                reciclerViewCategoriasProdutosAdapter = new ReciclerViewCategoriaLojasAdapter(categorias);
                reciclerViewCategoriasProdutos.setLayoutManager(new GridLayoutManager(container.getContext(),2));
                reciclerViewCategoriasProdutos.setAdapter(reciclerViewCategoriasProdutosAdapter);
            }

            @Override
            public void onError(String error) {
                Toast.makeText(container.getContext(), "erro onError: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }


    private void inicializaComponentes(View rootView) {
        reciclerViewCategoriasProdutos = rootView.findViewById(R.id.reciclerViewCategoriaProdutos);
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
//            reciclerViewCategoriasProdutosAdapter = new ReciclerViewAguaProdutosAdapter(pdts);
//            reciclerViewAguaProdutos.setAdapter(reciclerViewCategoriasProdutosAdapter);
//
//        } else {
//            Toast.makeText(this.getContext(), "Não foi possível popular lista de agua", Toast.LENGTH_SHORT).show();
//        }
//    }
}
