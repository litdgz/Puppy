package com.litdgz.puppy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityContacto extends AppCompatActivity {
    private EditText etNombre;
    private EditText etEmail;
    private EditText etMensaje;
    private Button btnEnviarMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionbar = (Toolbar) findViewById(R.id.ab_main_miActionBar);
        setSupportActionBar(miActionbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNombre = (EditText) findViewById(R.id.etv_nombre);
        etEmail = (EditText) findViewById(R.id.etv_email);
        etMensaje = (EditText) findViewById(R.id.etv_mensaje);
        btnEnviarMensaje = (Button) findViewById(R.id.btn_enviar_mensaje);

        btnEnviarMensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etEmail.getText().toString().isEmpty() && !etNombre.getText().toString().isEmpty()
                && !etMensaje.getText().toString().isEmpty()) {

                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{etEmail.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, etNombre.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, etMensaje.getText().toString());
//                    intent.setType("message/rfc822");
                    intent.setData(Uri.parse("mailto:"));
                    if (intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                    }else{
                        Toast.makeText(ActivityContacto.this, "There is no application that supports this action",
                                Toast.LENGTH_SHORT).show();
                    }


                } else {
                    Toast.makeText(ActivityContacto.this, "Please fill al the fields",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}