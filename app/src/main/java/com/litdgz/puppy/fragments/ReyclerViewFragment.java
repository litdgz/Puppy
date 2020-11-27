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
import com.litdgz.puppy.presentador.IRecyclerViewFragmentPresenter;
import com.litdgz.puppy.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class ReyclerViewFragment extends Fragment implements IRecyclerViewFragmentView{

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_reyclerview, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rv_fragment_recycle_view);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());


        return  v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

}
