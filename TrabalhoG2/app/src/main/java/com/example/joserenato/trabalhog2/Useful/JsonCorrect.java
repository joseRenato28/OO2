package com.example.joserenato.trabalhog2.Useful;

import com.example.joserenato.trabalhog2.Model.Release;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by JoseRenato on 19/06/2017.
 */

public class JsonCorrect implements JsonDeserializer<Release> {
    @Override
    public Release deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonElement element = json.getAsJsonObject();
        if(json.getAsJsonObject() != null){
            element = json.getAsJsonObject();
        }
        return (new Gson().fromJson(element, Release.class));
    }
}
