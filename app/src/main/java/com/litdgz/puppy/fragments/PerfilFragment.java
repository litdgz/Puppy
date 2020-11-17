package com.litdgz.puppy.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.litdgz.puppy.R;
import com.litdgz.puppy.adapter.MascotaAdaptadorGrid;
import com.litdgz.puppy.pojo.Mascota;
import com.litdgz.puppy.presentador.IRecyclerViewFragmentPresenter;
import com.litdgz.puppy.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class PerfilFragment extends Fragment implements IRecyclerViewFragmentViewGrid{

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    private IRecyclerViewFragmentPresenter presenter;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rv_fragment_perfil);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        listaMascotas.setLayoutManager(glm);
    }

    @Override
    public MascotaAdaptadorGrid crearAdaptadorGrid(ArrayList<Mascota> mascotas) {
        MascotaAdaptadorGrid adaptador = new MascotaAdaptadorGrid(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptadorGrid adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

}