package com.eltiempoes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eltiempoes.R;
import com.eltiempoes.rest.models.Provincia;

import java.util.List;

public class EltiempoAdapter extends RecyclerView.Adapter<EltiempoAdapter.ViewHolder> {
    private List<Provincia> datos;


    public EltiempoAdapter(List<Provincia> datos){
        this.datos = datos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mview = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(mview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.provincia.setText(datos.get(position).getNombreProvincia());
        holder.provincia.setId(Integer.parseInt(datos.get(position).getCodprov()));

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView provincia;
        private Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.provincia);
            provincia = itemView.findViewById(R.id.provincia);

        }
    }
}
