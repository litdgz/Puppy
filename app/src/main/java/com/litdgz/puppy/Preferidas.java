package com.litdgz.puppy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import com.litdgz.puppy.adapter.MascotaAdaptador;
import com.litdgz.puppy.fragments.IRecyclerViewFragmentView;
import com.litdgz.puppy.pojo.Mascota;
import com.litdgz.puppy.presentador.IRecyclerViewFragmentPresenter;
import com.litdgz.puppy.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class Preferidas extends AppCompatActivity implements IRecyclerViewFragmentView {
    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferidas);

        Toolbar miActionbar = (Toolbar) findViewById(R.id.ab_prefe_miActionBar);
        setSupportActionBar(miActionbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rv_prefe_recycle_view);

        presenter = new RecyclerViewFragmentPresenter(this, this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}