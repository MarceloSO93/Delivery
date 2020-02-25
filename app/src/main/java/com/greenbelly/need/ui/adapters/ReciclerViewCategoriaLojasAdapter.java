package com.greenbelly.need.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.greenbelly.need.R;
import com.greenbelly.need.ui.activits.LojasActivity;
import com.greenbelly.need.ui.model.CategoriaLoja;
import com.greenbelly.need.ui.util.Base64Util;

import java.util.ArrayList;
import java.util.List;


public class ReciclerViewCategoriaLojasAdapter extends RecyclerView.Adapter<ReciclerViewCategoriaLojasAdapter.ViewHolderCategoriaLojas> {


    private List<CategoriaLoja> categorias;
    private View viewLinhaReciclerView;
    private ViewGroup viewPai;

    private List<CategoriaLoja> categoriasSelecionados = new ArrayList<>();

    public ReciclerViewCategoriaLojasAdapter(List<CategoriaLoja> categorias) {
        this.categorias = categorias;
    }

    @Override
    public ViewHolderCategoriaLojas onCreateViewHolder(ViewGroup parent, int viewType) {
        viewPai = parent;

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());


        this.viewLinhaReciclerView = layoutInflater.inflate(R.layout.item_categorias_produtos, parent, false);
        ViewHolderCategoriaLojas holderEvento = new ViewHolderCategoriaLojas(viewLinhaReciclerView, parent.getContext());

        return holderEvento;
    }

    @Override
    public void onBindViewHolder(ViewHolderCategoriaLojas holder, int position) {

        CategoriaLoja categoria = categorias.get(position);

        holder.id = categoria.getId();
//        holder.txtNome.setText(categoria.getNome());

        if (holder.imageCategoriaLoja != null && categoria.getImage() != null) {
            holder.imageCategoriaLoja.setImageBitmap(Base64Util.imageStringToBitmap(categoria.getImage(), 500, 300));
        } else {
            int img = this.viewLinhaReciclerView.getResources().getIdentifier("@drawable/" + "amaciante_jjguimaraes_img", null, holder.context.getPackageName());
            holder.imageCategoriaLoja.setImageResource(img);
        }
    }

    public class ViewHolderCategoriaLojas extends RecyclerView.ViewHolder {

        public Long id;
//        public TextView txtNome;
        public ImageView imageCategoriaLoja;
        public Context context;
        public CardView cardView;


        public ViewHolderCategoriaLojas(final View view, final Context context) {
            super(view);
            this.context = context;
//            txtNome = (TextView) view.findViewById(R.id.txtNome);
            imageCategoriaLoja = (ImageView) view.findViewById(R.id.img_marca);
            cardView = (CardView) view.findViewById(R.id.cardViewLimpeza);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, LojasActivity.class);
                    intent.putExtra("categoriaId", id);
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
        return categorias.size();
    }


}


