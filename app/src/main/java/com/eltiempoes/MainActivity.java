package com.eltiempoes;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.eltiempoes.adapters.EltiempoAdapter;
import com.eltiempoes.fragments.FragmentDetallesProvincia;
import com.eltiempoes.fragments.FragmentListaProvincias;
import com.eltiempoes.rest.models.Provincia;

import java.util.ArrayList;
import java.util.List;


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
        String a = Integer.toString(view.getId());
        if(a.length()==1){
            id = "0"+a;
        }else id = a;
    }
}