package com.litdgz.puppy.presentador;

import android.content.Context;

import com.litdgz.puppy.db.ConstructorMascotas;
import com.litdgz.puppy.fragments.IRecyclerViewFragmentView;
import com.litdgz.puppy.fragments.IRecyclerViewFragmentViewGrid;
import com.litdgz.puppy.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {
    private IRecyclerViewFragmentViewGrid iRecyclerViewFragmentViewGrid;
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentViewGrid iRecyclerViewFragmentViewGrid, Context context) {
        this.iRecyclerViewFragmentViewGrid = iRecyclerViewFragmentViewGrid;
        this.context = context;
        obtenerMascotasBaseDatosGrid();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotas();
        mostrarMascotasRV();


    }
// grid
    @Override
    public void obtenerMascotasBaseDatosGrid() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotasGrid();
        mostrarMascotasRVGrid();

    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
// grid
    @Override
    public void mostrarMascotasRVGrid() {
        iRecyclerViewFragmentViewGrid.inicializarAdaptadorRV(iRecyclerViewFragmentViewGrid.crearAdaptadorGrid(mascotas));
        iRecyclerViewFragmentViewGrid.generarGridLayout();
    }
}
