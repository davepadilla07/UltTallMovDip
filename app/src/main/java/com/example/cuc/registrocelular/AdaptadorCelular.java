package com.example.cuc.registrocelular;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by CUC on 3/06/2017.
 */

public class AdaptadorCelular extends RecyclerView.Adapter<AdaptadorCelular.CelularViewHolder> {

    private ArrayList<Celular> celulares;
    private OnCelularClickListener clickListener;

    public AdaptadorCelular(ArrayList<Celular> celulares, OnCelularClickListener clickListener){
        this.celulares=celulares;
        this.clickListener=clickListener;
    }


    @Override
    public AdaptadorCelular.CelularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_celular,parent,false);
        return new CelularViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdaptadorCelular.CelularViewHolder holder, int position) {
        final Celular p = celulares.get(position);


        Picasso.with(holder.view.getContext()).load(p.getFoto()).into(holder.foto);
        holder.codcertificado.setText(p.getCodCertificado());
        holder.nombre.setText(p.getNombre());
        holder.marca.setText(p.getMarca());
        holder.color.setText(p.getColor());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onCelularClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return celulares.size();
    }

    public static class CelularViewHolder extends RecyclerView.ViewHolder {
        private ImageView foto;
        private TextView codcertificado;
        private TextView nombre;
        private TextView marca;
        private TextView color;
        private View view;

        public CelularViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            foto=(ImageView)itemView.findViewById(R.id.foto);
            codcertificado=(TextView)itemView.findViewById(R.id.txtCodCertificado);
            nombre=(TextView)itemView.findViewById(R.id.txtNombreC);
            marca=(TextView)itemView.findViewById(R.id.txtMarca);
            color=(TextView)itemView.findViewById(R.id.txtColor);
        }
    }
    public interface OnCelularClickListener{
        void onCelularClick(Celular p);
    }
}
