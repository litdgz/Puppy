package com.litdgz.puppy.fragments;

import com.litdgz.puppy.adapter.MascotaAdaptadorGrid;
import com.litdgz.puppy.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentViewGrid {

    public void generarGridLayout();

    public MascotaAdaptadorGrid crearAdaptadorGrid(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptadorGrid adaptador);


}
