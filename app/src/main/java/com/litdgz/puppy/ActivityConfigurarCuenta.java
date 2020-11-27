package com.litdgz.puppy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class ActivityConfigurarCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);

        Toolbar miActionbar = (Toolbar) findViewById(R.id.ab_main_miActionBar);
        setSupportActionBar(miActionbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}