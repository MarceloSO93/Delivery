package com.greenbelly.need.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.greenbelly.need.R;
import com.greenbelly.need.ui.activits.ProdutoActivity;
import com.greenbelly.need.ui.model.Produto;
import com.greenbelly.need.ui.util.Base64Util;

import java.util.List;


public class ReciclerViewProdutosLojaAdapter extends RecyclerView.Adapter<ReciclerViewProdutosLojaAdapter.ViewHolderProdutos> {


    private List<Produto> produtos;
    private View viewLinhaReciclerView;
    private ViewGroup viewPai;


    public ReciclerViewProdutosLojaAdapter(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public ViewHolderProdutos onCreateViewHolder(ViewGroup parent, int viewType) {
        viewPai = parent;

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());


        this.viewLinhaReciclerView = layoutInflater.inflate(R.layout.item_list_produtos_loja, parent, false);
        ViewHolderProdutos holderEvento = new ViewHolderProdutos(viewLinhaReciclerView, parent.getContext());

        return holderEvento;
    }

    @Override
    public void onBindViewHolder(ViewHolderProdutos holder, int position) {

        Produto produto = produtos.get(position);

        holder.id = produto.getId();
        holder.txtNome.setText(produto.getNome());
        holder.txtDescricao.setText(produto.getDescricao());
        holder.txtValor.setText(produto.getValor().toString());


        if (holder.imageProduto != null && produto.getImagem() != null) {
            holder.imageProduto.setImageBitmap(Base64Util.imageStringToBitmap(produto.getImagem(), 200, 200));
        } else {
            int img = this.viewLinhaReciclerView.getResources().getIdentifier("@drawable/" + "amaciante_jjguimaraes_img", null, holder.context.getPackageName());
            holder.imageProduto.setImageResource(img);
        }
    }

    public class ViewHolderProdutos extends RecyclerView.ViewHolder {

        public TextView txtNome;
        public TextView txtDescricao;
        public TextView txtValor;
        public ImageView imageProduto;
        public Context context;
        public CardView cardView;
        public Long id;


        public ViewHolderProdutos(final View view, final Context context) {
            super(view);
            this.context = context;
            txtNome = (TextView) view.findViewById(R.id.txtNome);
            txtValor = (TextView) view.findViewById(R.id.txtValor);
            txtDescricao = (TextView) view.findViewById(R.id.txtDescricao);
            imageProduto = (ImageView) view.findViewById(R.id.img_logo);
            cardView = (CardView) view.findViewById(R.id.cardViewProdutosLoja);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, ProdutoActivity.class);
                    intent.putExtra("produtoId", id);
                    context.startActivity(intent);

                }
            });

            view.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {
                    return true;
                }
            });

        }
    }


    @Override
    public int getItemCount() {
        return produtos.size();
    }


}


