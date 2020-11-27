package com.litdgz.puppy.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.litdgz.puppy.pojo.Mascota;
import com.litdgz.puppy.restApi.ConstantesRestApi;
import com.litdgz.puppy.restApi.JsonKeys;
import com.litdgz.puppy.restApi.model.MascotaResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MascotaDeserializador implements JsonDeserializer<MascotaResponse> {

    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaResponse.setMascotas(deserializarMascotaDeJson(mascotaResponseData));

        return mascotaResponse;
    }

    private ArrayList<Mascota> deserializarMascotaDeJson(JsonArray mascotaResponseData){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        for (int i = 0; i < mascotaResponseData.size(); i++){
            JsonObject mascotaResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();

            // cantidad de likes
            int like               = mascotaResponseDataObject.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();
            //url de la foto
            String urlFoto         = mascotaResponseDataObject.get(JsonKeys.MEDIA_URL).getAsString();
            // usuario
            String nombreCompleto  = mascotaResponseDataObject.get(JsonKeys.USER).getAsString();

            //id de usuario entrando primero a OWNER como objeto
            JsonObject userJson    = mascotaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_OWNER);
            String idPerfil              = userJson.get(JsonKeys.USER_ID).getAsString();

            Mascota mascotaActual = new Mascota();
            mascotaActual.setIdPerfil(idPerfil);
            mascotaActual.setNombreCompleto(nombreCompleto);
            mascotaActual.setUrlFoto(urlFoto);
            mascotaActual.setLikes(like);

            mascotas.add(mascotaActual);
        }
        return mascotas;
    }


}
