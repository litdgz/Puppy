package com.litdgz.puppy.restApi;

import com.litdgz.puppy.restApi.model.MascotaResponse;
import com.litdgz.puppy.restApi.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface EndPointApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();

    @FormUrlEncoded
    @POST(ConstantesRestApiFirebase.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarUsuario(@Field("token") String token,
                                           @Field("instagram") String instagram);
}
