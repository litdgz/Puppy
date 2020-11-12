package com.litdgz.puppy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.litdgz.puppy.R;
import com.litdgz.puppy.adapter.MascotaAdaptador;
import com.litdgz.puppy.pojo.Mascota;

import java.util.ArrayList;

public class ReyclerViewFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_reyclerview, container, false);


        listaMascotas = (RecyclerView) v.findViewById(R.id.rv_fragment_recycle_view);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return  v;
    }


    MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.corgi, "Chafa", 0));
        mascotas.add(new Mascota(R.drawable.dot, "Dot", 0));
        mascotas.add(new Mascota(R.drawable.choppy1, "Choppy", 0));
        mascotas.add(new Mascota(R.drawable.soo, "Soo", 0));
        mascotas.add(new Mascota(R.drawable.leon, "Leon", 0));
    }


}
