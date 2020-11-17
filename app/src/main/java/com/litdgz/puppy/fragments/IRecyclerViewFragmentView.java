package com.litdgz.puppy.fragments;

import com.litdgz.puppy.adapter.MascotaAdaptador;
import com.litdgz.puppy.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);


}
