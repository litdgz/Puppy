package com.litdgz.puppy.db;

import android.content.ContentValues;
import android.content.Context;

import com.litdgz.puppy.R;
import com.litdgz.puppy.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }



    public ArrayList<Mascota> obtenerMascotas(){

        BaseDatos db = new BaseDatos(context);
        insertarCincoMascotas(db);
        return db.obtenerTodasLasMascotas();
    }

    public ArrayList<Mascota> obtenerMascotasGrid(){
        BaseDatos db = new BaseDatos(context);
        insertarFotosPerfil(db);
        return db.obtenerTodasLasMascotasGrid();
    }

    public void insertarCincoMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.corgi);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Chafa");

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.dot);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Dot");

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.choppy1);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Choppy");

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.soo);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Soo");

        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.leon);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Leon");

        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES, LIKE);
        db.insertarLikeMascota(contentValues);

    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

    public void insertarFotosPerfil(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_GRID_FOTO, R.drawable.corgi);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_GRID_NUMERO_LIKES, 1);

        db.insertarMascotasGrid(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_GRID_FOTO, R.drawable.corgi);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_GRID_NUMERO_LIKES, 3);

        db.insertarMascotasGrid(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_GRID_FOTO, R.drawable.corgi);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_GRID_NUMERO_LIKES, 4);

        db.insertarMascotasGrid(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_GRID_FOTO, R.drawable.corgi);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_GRID_NUMERO_LIKES, 6);

        db.insertarMascotasGrid(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_GRID_FOTO, R.drawable.corgi);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_GRID_NUMERO_LIKES, 7);

        db.insertarMascotasGrid(contentValues);






    }

    // Grid
   /* public ArrayList<Mascota> obtenerMascotasGrid(){

        ArrayList<Mascota>mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.corgi, 5));
        mascotas.add(new Mascota(R.drawable.corgi, 6));
        mascotas.add(new Mascota(R.drawable.corgi, 7));
        mascotas.add(new Mascota(R.drawable.corgi, 8));
        mascotas.add(new Mascota(R.drawable.corgi, 1));
        mascotas.add(new Mascota(R.drawable.corgi, 8));
        mascotas.add(new Mascota(R.drawable.corgi, 5));
        mascotas.add(new Mascota(R.drawable.corgi, 3));
        mascotas.add(new Mascota(R.drawable.corgi, 1));
        mascotas.add(new Mascota(R.drawable.corgi, 2));
        mascotas.add(new Mascota(R.drawable.corgi, 9));

        return mascotas;
    }
*/
}
