package com.litdgz.puppy.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.litdgz.puppy.restApi.ConstantesRestApi;
import com.litdgz.puppy.restApi.EndPointApi;
import com.litdgz.puppy.restApi.deserializador.MascotaDeserializador;
import com.litdgz.puppy.restApi.model.MascotaResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public EndPointApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndPointApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());

        return gsonBuilder.create();
    }
}
