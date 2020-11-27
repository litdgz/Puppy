package com.litdgz.puppy.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.litdgz.puppy.pojo.Mascota;

import java.util.ArrayList;
import java.util.zip.CheckedOutputStream;

public class BaseDatos extends SQLiteOpenHelper{

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "("+
                                         ConstantesBaseDatos.TABLE_MASCOTAS_ID     + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                         ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, "  +
                                         ConstantesBaseDatos.TABLE_MASCOTAS_FOTO   + " INTEGER" +
                                         ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "(" +
                                             ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                             ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + " INTEGER, " +
                                             ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + " INTEGER, " +
                                             "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + ") " +
                                             "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                                             ")";

        String queryCrearTablaMascotaGrid = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA_GRID + "("+
                                            ConstantesBaseDatos.TABLE_MASCOTAS_GRID_ID     + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                            ConstantesBaseDatos.TABLE_MASCOTAS_GRID_FOTO   + " INTEGER, " +
                                            ConstantesBaseDatos.TABLE_MASCOTA_GRID_NUMERO_LIKES + " INTEGER" +
                                            ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
        db.execSQL(queryCrearTablaMascotaGrid);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTA_GRID);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES +") as likes " +
                                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setNumeroFavoritos(registrosLikes.getInt(0));
            } else {
                mascotaActual.setNumeroFavoritos(0);
            }

            mascotas.add(mascotaActual);
        }
        db.close();

        return mascotas;

    }

    public ArrayList<Mascota> obtenerTodasLasMascotasGrid(){

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA_GRID;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);


        while (registros.moveToNext()) {
           /* Mascota mascotaActual = new Mascota();

            mascotaActual.setIdGrid(registros.getInt(0));
            mascotaActual.setFoto(registros.getInt(1));
            mascotaActual.setNumeroFavoritos(registros.getInt(2));

            mascotas.add(mascotaActual);*/
      }
        db.close();

        return mascotas;

    }


    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    public void insertarMascotasGrid(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA_GRID, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues);
        db.close();
    }

    public int obtenerLikesMascota(Mascota mascota){
        int likes = 0;
        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + ")" +
                       " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                       " WHERE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_ID_MASCOTA + "=" + mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
