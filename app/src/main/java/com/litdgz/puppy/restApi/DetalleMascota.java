package com.litdgz.puppy.restApi;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.litdgz.puppy.MainActivity;
import com.litdgz.puppy.R;
import com.litdgz.puppy.fragments.PerfilFragment;
import com.squareup.picasso.Picasso;

public class DetalleMascota  extends AppCompatActivity {
    private static final String KEY_EXTRA_URL = "url";
    private static final String KEY_EXTRA_LIKES = "like";

    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto_foto);

        Bundle extras = getIntent().getExtras();
        String url = extras.getString(KEY_EXTRA_URL);
        int likes = extras.getInt(KEY_EXTRA_LIKES);

        tvLikesDetalle = (TextView) findViewById(R.id.tv_card_numero_likes_detalle);
        tvLikesDetalle.setText(String.valueOf(likes));

        imgFotoDetalle = (ImageView) findViewById(R.id.iv_card_imagen_mascota_detalle);
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.choppy1)
                .into(imgFotoDetalle);
    }

/*    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(DetalleMascota.this, PerfilFragment.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }*/
}
