package com.greenbelly.need.ui.activits;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.greenbelly.need.R;
import com.greenbelly.need.ui.model.Produto;
import com.greenbelly.need.ui.services.ProdutosService;
import com.greenbelly.need.ui.util.Base64Util;
import com.greenbelly.need.ui.webapi.SimpleCallback;

import java.math.BigDecimal;

public class ProdutoActivity extends AppCompatActivity {

    private Produto produto;
    private Long produtoId;
    private int unidades;
    private BigDecimal valorTotal;

    private ImageView imageProduto;
    private TextView txtNome;
    private TextView txtValor;
    private TextView txtValorTotal;
    private TextView txtDescricao;
    private Button btnMaisUm;
    private TextView txtUnidades;
    private Button btnMenosUm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        Intent intent = getIntent(); // gets the previously created intent
        produtoId = intent.getLongExtra("produtoId", 0L);

        inicializaComponentes();


        buscarProduto(this, produtoId);

        btnMaisUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unidades++;
                txtUnidades.setText(String.valueOf(unidades));
                valorTotal = produto.getValor().multiply(new BigDecimal(unidades));
                txtValorTotal.setText(String.valueOf(valorTotal));
            }
        });

        btnMenosUm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (unidades > 1) {
                    unidades--;
                    txtUnidades.setText(String.valueOf(unidades));
                    valorTotal = produto.getValor().multiply(new BigDecimal(unidades));
                    txtValorTotal.setText(String.valueOf(valorTotal));
                }
            }
        });


    }


    private void buscarProduto(final Context contex, Long produtoId) {

        ProdutosService.getProdutosById(produtoId, new SimpleCallback<Produto>() {
            @Override
            public void onResponse(Produto response) {
                produto = response;

                txtNome.setText(produto.getNome());
                txtValor.setText("R$ " + produto.getValor().toString());
                txtDescricao.setText(produto.getDescricao());
                valorTotal = produto.getValor();
                txtValorTotal.setText(String.valueOf(valorTotal));

                if (produto.getImagem() != null) {
                    imageProduto.setImageBitmap(Base64Util.imageStringToBitmap(produto.getImagem(), 900, 700));
                }

            }

            @Override
            public void onError(String error) {
                Toast.makeText(contex, "erro onError: " + error.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void inicializaComponentes() {

        txtNome = findViewById(R.id.txtNome);
        imageProduto = findViewById(R.id.img_show_produto);
        txtValor = findViewById(R.id.txtValor);
        txtDescricao = findViewById(R.id.txtDescricao);
        txtValorTotal = findViewById(R.id.txtValorTotal);
        btnMaisUm = findViewById(R.id.btnMaisUm);
        btnMenosUm = findViewById(R.id.btnMenosUm);
        txtUnidades = findViewById(R.id.txtUnidades);
    }
}