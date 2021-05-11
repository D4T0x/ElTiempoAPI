package com.eltiempoes.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eltiempoes.R;
import com.eltiempoes.rest.models.Ciudade;
import com.eltiempoes.rest.models.Example;
import com.eltiempoes.rest.models.Provincia;

import java.util.List;

public class EltiempoAdapter extends RecyclerView.Adapter<EltiempoAdapter.ViewHolder> {
    private List<Ciudade> datos;

    public EltiempoAdapter(List<Ciudade> datos){
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
        holder.ciudad.setText(datos.get(position).getNameProvince());
        holder.tMax.setText(datos.get(position).getTemperatures().getMax());
        holder.tMin.setText(datos.get(position).getTemperatures().getMin());
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView ciudad;
        private TextView tMax;
        private TextView tMin;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ciudad = itemView.findViewById(R.id.ciudad);
            tMax = itemView.findViewById(R.id.tMax);
            tMin = itemView.findViewById(R.id.tMin);
        }
    }
}
