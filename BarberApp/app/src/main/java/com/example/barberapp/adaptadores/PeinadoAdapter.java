package com.example.barberapp.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barberapp.CardActivity;
import com.example.barberapp.DatosPeinado;
import com.example.barberapp.R;

public class PeinadoAdapter extends RecyclerView.Adapter<PeinadoAdapter.ViewHolder> {
    DatosPeinado[] datosPeinado;
    Context context;

    public PeinadoAdapter(DatosPeinado[] datosPeinado, CardActivity activity) {
        this.datosPeinado = datosPeinado;
        this.context = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cortes_item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final DatosPeinado datosPeinadoList = datosPeinado[position];
        holder.textViewNombre.setText(datosPeinadoList.getNombrePeinado());
        holder.textViewDescripcion.setText(datosPeinadoList.getDescripcionPeinado());
        holder.imagenPeinado.setImageResource(datosPeinadoList.getFotoPeinado());
    }

    @Override
    public int getItemCount() {
        return datosPeinado.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imagenPeinado;
        TextView textViewNombre;
        TextView textViewDescripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenPeinado = itemView.findViewById(R.id.imageview);
            textViewNombre = itemView.findViewById(R.id.textName);
            textViewDescripcion = itemView.findViewById(R.id.textDescription);
        }
    }
}
