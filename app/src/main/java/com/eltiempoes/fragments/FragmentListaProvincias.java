package com.eltiempoes.fragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.eltiempoes.R;
import com.eltiempoes.adapters.EltiempoAdapter;
import com.eltiempoes.rest.eltiempoAPI;
import com.eltiempoes.rest.models.Provincia;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class FragmentListaProvincias extends Fragment {


    private List<Provincia> datos = new ArrayList<>();
    private EltiempoAdapter adapter;
    private RecyclerView recyclerProvincias;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_lista_provincias, container, false);

        datos = new ArrayList<>();
        adapter = new EltiempoAdapter(datos);
        recyclerProvincias = vista.findViewById(R.id.listaProvincias);
        recyclerProvincias.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerProvincias.setAdapter(adapter);
        downloadData();

        return vista;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void downloadData(){
        eltiempoAPI.getInstance()
                .getHome()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMapIterable(x -> x.getProvincias())
                .map(x -> datos.add(x))
                .subscribe( x -> adapter.notifyDataSetChanged());

    }


}