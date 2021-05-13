package com.eltiempoes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.eltiempoes.adapters.EltiempoAdapter;
import com.eltiempoes.fragments.FragmentDetallesProvincia;
import com.eltiempoes.fragments.FragmentListaProvincias;
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
    public static String id;
    private List<Provincia> datos = new ArrayList<>();
    private EltiempoAdapter adapter;

    FragmentTransaction transaction;
    Fragment fragmentListaProvincias, fragmentDetallesProvincia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentListaProvincias = new FragmentListaProvincias();
        fragmentDetallesProvincia = new FragmentDetallesProvincia();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragments, fragmentListaProvincias).commit();
    }

    public void onClick(View view){
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedorFragments, fragmentDetallesProvincia).commit();
        transaction.addToBackStack(null);
        Log.e("Estas bien", ""+view.getId());
        String a = Integer.toString(view.getId());
        if(a.length()==1){
            id = "0"+a;
        }else id = a;

    }
}