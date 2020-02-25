package com.greenbelly.need;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.greenbelly.need.ui.fragments.FragmentCategoriasLocacao;
import com.greenbelly.need.ui.fragments.FragmentCategoriasServicos;
import com.greenbelly.need.ui.main.SectionsPagerAdapter;
import com.greenbelly.need.ui.fragments.FragmentCategoriasProdutos;

public class MainActivity extends AppCompatActivity {

//    private List<Produto> produtos = new ArrayList();
//    private List<CategoriaProduto> categoriasProdutos = new ArrayList();

    private static TabLayout tabLayout;
    private static ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criarInicializarViewPagers();

        //Instancia do botão flutuante
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void criarInicializarViewPagers() {

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        sectionsPagerAdapter.addFragment(new FragmentCategoriasProdutos(), "PRODUTOS");
        sectionsPagerAdapter.addFragment(new FragmentCategoriasServicos(), "SERVIÇOS");
        sectionsPagerAdapter.addFragment(new FragmentCategoriasLocacao(), "LOCAÇÃO DE BENS");

        //Instancia a view de paginas
        viewPager = findViewById(R.id.view_pager);

        //Seta uma sessão de adapter
        viewPager.setAdapter(sectionsPagerAdapter);

        tabLayout = findViewById(R.id.tabs);

        //Seta o visualizador de paginas
        tabLayout.setupWithViewPager(viewPager);

    }
}