package com.eltiempoes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.eltiempoes.adapters.EltiempoAdapter;
import com.eltiempoes.rest.Eltiempo;
import com.eltiempoes.rest.eltiempoAPI;
import com.eltiempoes.rest.models.Ciudade;
import com.eltiempoes.rest.models.Example;
import com.eltiempoes.rest.models.Provincia;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    private List<Provincia> datos = new ArrayList<>();
    private EltiempoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RecyclerView lista = (RecyclerView) findViewById(R.id.lista);

        adapter = new EltiempoAdapter(datos);
        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(adapter);
        downloadData();



    }

    public void sendMessage(View view){

        //.subscribe(x -> Log.e("Prueba",x.getTitle()));


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