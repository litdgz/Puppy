package com.litdgz.puppy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionbar = (Toolbar) findViewById(R.id.ab_main_miActionBar);
        setSupportActionBar(miActionbar);

        listaMascotas = (RecyclerView) findViewById(R.id.rv_main_recycle_view);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();


    }

    public void irPreferidas(View v) {
        Intent intent = new Intent(MainActivity.this, Preferidas.class);
        startActivity(intent);
    }

    MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas);
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