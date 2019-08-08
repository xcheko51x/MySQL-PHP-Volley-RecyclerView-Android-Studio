package com.example.ejemplovolleyrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterEquipo extends RecyclerView.Adapter<AdapterEquipo.ViewHolderEquipos> {

    ArrayList<Equipo> listaEquipos;

    public AdapterEquipo(ArrayList<Equipo> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    @NonNull
    @Override
    public ViewHolderEquipos onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_equipo, null, false);

        return new ViewHolderEquipos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderEquipos viewHolderEquipos, int i) {
        Picasso.get().load(listaEquipos.get(i).getEscudo()).resize(400, 500).into(viewHolderEquipos.ivEscudo);
        viewHolderEquipos.tvNombre.setText(listaEquipos.get(i).getNombre());
    }

    @Override
    public int getItemCount() {
        return listaEquipos.size();
    }

    public class ViewHolderEquipos extends RecyclerView.ViewHolder {

        ImageView ivEscudo;
        TextView tvNombre;

        public ViewHolderEquipos(@NonNull View itemView) {
            super(itemView);

            ivEscudo = itemView.findViewById(R.id.ivEscudo);
            tvNombre = itemView.findViewById(R.id.tvNombreEquipo);

        }
    }
}
