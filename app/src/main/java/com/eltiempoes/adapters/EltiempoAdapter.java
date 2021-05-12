package com.eltiempoes.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eltiempoes.R;
import com.eltiempoes.rest.eltiempoAPI;
import com.eltiempoes.rest.models.Ciudade;
import com.eltiempoes.rest.models.Example;
import com.eltiempoes.rest.models.Provincia;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

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
        holder.button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.e("Prueba", "Boton presionado");
                eltiempoAPI.getInstance()
                        .getProv(datos.get(position).getCodprov())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(x -> Log.e("Prueba",x.getTitle()));
            }
        });
        holder.provincia.setText(datos.get(position).getNombreProvincia());
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
