package com.litdgz.puppy.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.litdgz.puppy.R;
import com.litdgz.puppy.adapter.MascotaAdaptadorGrid;
import com.litdgz.puppy.pojo.Mascota;
import com.litdgz.puppy.presentador.IRecyclerViewFragmentPresenter;
import com.litdgz.puppy.presentador.RecyclerViewFragmentPresenter;
import com.litdgz.puppy.restApi.EndPointApi;
import com.litdgz.puppy.restApi.adapter.RestApiAdapter;
import com.litdgz.puppy.restApi.model.MascotaResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilFragment extends Fragment implements IRecyclerViewFragmentViewGrid{

    private RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;
    private IRecyclerViewFragmentPresenter presenter;
    private TextView nombrePerfil;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rv_fragment_perfil);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        nombrePerfil = (TextView) v.findViewById(R.id.tv_card_nombre_perfil);
        obtenerMediosRecientes();

        return v;
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        listaMascotas.setLayoutManager(glm);
    }

    @Override
    public MascotaAdaptadorGrid crearAdaptadorGrid(ArrayList<Mascota> mascotas) {
        MascotaAdaptadorGrid adaptador = new MascotaAdaptadorGrid(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptadorGrid adaptador) {
        listaMascotas.setAdapter(adaptador);
    }

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
                nombrePerfil.setText(mascotas.get(0).getNombreCompleto());
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Algo pago en la conexion intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.i("FALLO LA CONEXION", t.toString());

            }
        });
    }

}