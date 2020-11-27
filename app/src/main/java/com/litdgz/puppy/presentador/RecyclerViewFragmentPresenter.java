package com.litdgz.puppy.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.litdgz.puppy.db.ConstructorMascotas;
import com.litdgz.puppy.fragments.IRecyclerViewFragmentView;
import com.litdgz.puppy.fragments.IRecyclerViewFragmentViewGrid;
import com.litdgz.puppy.pojo.Mascota;
import com.litdgz.puppy.restApi.EndPointApi;
import com.litdgz.puppy.restApi.adapter.RestApiAdapter;
import com.litdgz.puppy.restApi.model.MascotaResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        //obtenerMascotasBaseDatosGrid();

        obtenerMediosRecientes();

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
    public void obtenerMediosRecientes() {

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();

        EndPointApi endPointApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall = endPointApi.getRecentMedia();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();
                mascotas = mascotaResponse.getMascotas();
                mostrarMascotasRVGrid();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "Algo pago en la conexion intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.i("FALLO LA CONEXION", t.toString());

            }
        });
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
