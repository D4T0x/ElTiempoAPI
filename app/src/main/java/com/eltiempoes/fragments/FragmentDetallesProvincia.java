package com.eltiempoes.fragments;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.eltiempoes.MainActivity;
import com.eltiempoes.rest.eltiempoAPI;
import com.eltiempoes.rest.models.Provincia;
import com.eltiempoes.rest.models.Provincias.Ciudade;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FragmentDetallesProvincia extends Fragment {

    private List<Provincia> datos;


    public FragmentDetallesProvincia() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ScrollView scroller = new ScrollView(getActivity());
        TextView text = new TextView(getActivity());
        int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                4, getActivity().getResources().getDisplayMetrics());
        text.setPadding(padding, padding, padding, padding);
        scroller.addView(text);
        downloadData(text);
        //text.setText(MainActivity.id);
        return scroller;

    }

    private void downloadData(TextView text) {
    try{
        eltiempoAPI.getInstance()
                .getProv(MainActivity.id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(x -> text.setText(x.getTitle()+
                        "\n\nHoy:\n"+x.getToday().getP()+
                        "\n\nMañana:\n"+x.getToday().getP()+
                        "\n\n"+imprimeCiudades(x.getCiudades())
                ));
    } catch (Exception e) {
        Log.e("Error: ","En downloadData(TextView text)");
        e.printStackTrace();
    }


    }

    private String imprimeCiudades(List<Ciudade> ciudades) {
        String a = "";
        for (Ciudade c:ciudades) {
            a += "\n"+c.getName()+
                    "\n"+c.getStateSky().getDescription()+
                    "\nT.Max: "+c.getTemperatures().getMax()+
                    "\nT.Min: "+c.getTemperatures().getMin()+
                    "\n\n";
        }
        return a;
    }
}