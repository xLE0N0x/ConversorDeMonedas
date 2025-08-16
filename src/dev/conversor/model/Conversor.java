package dev.conversor.model;

import com.google.gson.Gson;

public class Conversor {

    public static Moneda convertirDatos(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Moneda.class);
    }
}
