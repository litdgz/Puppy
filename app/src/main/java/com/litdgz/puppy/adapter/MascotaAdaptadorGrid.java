package com.litdgz.puppy.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.litdgz.puppy.pojo.Mascota;
import com.litdgz.puppy.R;

import java.util.ArrayList;

public class MascotaAdaptadorGrid extends RecyclerView.Adapter<MascotaAdaptadorGrid.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptadorGrid(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }



    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas_grid, parent, false);

        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
//        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvNumeroLikes.setText(String.valueOf(mascota.getNumeroFavoritos()));
        /*mascotaViewHolder.btnhueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int masUno = mascota.getNumeroFavoritos() + 1;
                mascota.setNumeroFavoritos(masUno);
                mascotaViewHolder.tvNumeroLikes.setText(String.valueOf(mascota.getNumeroFavoritos()));
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgMascota;
//        private TextView tvNombre;
        private TextView tvNumeroLikes;
//        private Button btnhueso;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgMascota    = (ImageView) itemView.findViewById(R.id.iv_card_imagen_mascota2);
//            tvNombre      = (TextView) itemView.findViewById(R.id.tv_card_nombre2);
            tvNumeroLikes = (TextView) itemView.findViewById(R.id.tv_card_numero_likes2);
//            btnhueso      = (Button) itemView.findViewById(R.id.btn_card_hueso2);
        }
    }
}
