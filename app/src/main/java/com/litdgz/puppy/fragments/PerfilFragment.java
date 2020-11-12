package com.litdgz.puppy.fragments;

import android.graphics.Rect;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.litdgz.puppy.R;
import com.litdgz.puppy.adapter.MascotaAdaptador;
import com.litdgz.puppy.adapter.MascotaAdaptadorGrid;
import com.litdgz.puppy.pojo.Mascota;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);


        listaMascotas = (RecyclerView) v.findViewById(R.id.rv_fragment_perfil);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);

        listaMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();


        return v;
    }

    MascotaAdaptadorGrid adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptadorGrid(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {

        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.corgi, "Chafa", 5));
        mascotas.add(new Mascota(R.drawable.corgi, "Dot", 6));
        mascotas.add(new Mascota(R.drawable.corgi, "Choppy", 7));
        mascotas.add(new Mascota(R.drawable.corgi, "Soo", 8));
        mascotas.add(new Mascota(R.drawable.corgi, "Leon", 1));
        mascotas.add(new Mascota(R.drawable.corgi, "Soo", 8));
        mascotas.add(new Mascota(R.drawable.corgi, "Soo", 5));
        mascotas.add(new Mascota(R.drawable.corgi, "Soo", 3));
        mascotas.add(new Mascota(R.drawable.corgi, "Soo", 1));
        mascotas.add(new Mascota(R.drawable.corgi, "Soo", 2));
        mascotas.add(new Mascota(R.drawable.corgi, "Soo", 9));

    }
}