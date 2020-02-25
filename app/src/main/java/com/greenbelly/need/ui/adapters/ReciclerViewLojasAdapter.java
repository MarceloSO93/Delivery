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
import com.greenbelly.need.ui.activits.ProdutosLojaActivity;
import com.greenbelly.need.ui.model.Loja;
import com.greenbelly.need.ui.util.Base64Util;

import java.util.List;


public class ReciclerViewLojasAdapter extends RecyclerView.Adapter<ReciclerViewLojasAdapter.ViewHolderLojas> {


    private List<Loja> lojas;
    private View viewLinhaReciclerView;
    private ViewGroup viewPai;


    public ReciclerViewLojasAdapter(List<Loja> lojas) {
        this.lojas = lojas;
    }

    @Override
    public ViewHolderLojas onCreateViewHolder(ViewGroup parent, int viewType) {
        viewPai = parent;

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());


        this.viewLinhaReciclerView = layoutInflater.inflate(R.layout.item_list_lojas, parent, false);
        ViewHolderLojas holderEvento = new ViewHolderLojas(viewLinhaReciclerView, parent.getContext());

        return holderEvento;
    }

    @Override
    public void onBindViewHolder(ViewHolderLojas holder, int position) {

        Loja loja = lojas.get(position);

        holder.txtNome.setText(loja.getNome());
        holder.id = loja.getId();

        if(loja.getEndereco() != null){
            holder.txtBairro.setText(loja.getEndereco().getBairro());
            holder.txtCidade.setText(loja.getEndereco().getCidade());
        }


        if (holder.imageLoja != null && loja.getLogo() != null) {
            holder.imageLoja.setImageBitmap(Base64Util.imageStringToBitmap(loja.getLogo(), 200, 200));
        } else {
            int img = this.viewLinhaReciclerView.getResources().getIdentifier("@drawable/" + "amaciante_jjguimaraes_img", null, holder.context.getPackageName());
            holder.imageLoja.setImageResource(img);
        }
    }

    public class ViewHolderLojas extends RecyclerView.ViewHolder {

        public TextView txtNome;
        public TextView txtBairro;
        public TextView txtCidade;
        public ImageView imageLoja;
        public Context context;
        public CardView cardView;
        public Long id;


        public ViewHolderLojas(final View view, final Context context) {
            super(view);
            this.context = context;
            txtNome = (TextView) view.findViewById(R.id.txtNome);
            txtBairro = (TextView) view.findViewById(R.id.txtBairro);
            txtCidade = (TextView) view.findViewById(R.id.txtCidade);
            imageLoja = (ImageView) view.findViewById(R.id.img_logo);
            cardView = (CardView) view.findViewById(R.id.cardViewLoja);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, ProdutosLojaActivity.class);
                    intent.putExtra("lojaId", id);
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
        return lojas.size();
    }


}


