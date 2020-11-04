package com.litdgz.puppy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Preferidas extends AppCompatActivity {
    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferidas);

        Toolbar miActionbar = (Toolbar) findViewById(R.id.ab_prefe_miActionBar);
        setSupportActionBar(miActionbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rv_prefe_recycle_view);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {

        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.corgi, "Chafa", 0));
        mascotas.add(new Mascota(R.drawable.dot, "Dot", 0));
        mascotas.add(new Mascota(R.drawable.choppy1, "Choppy", 0));
        mascotas.add(new Mascota(R.drawable.soo, "Soo", 0));
        mascotas.add(new Mascota(R.drawable.leon, "Leon", 0));
    }

}