package com.litdgz.puppy.restApi;

import com.litdgz.puppy.restApi.model.MascotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndPointApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();
}
