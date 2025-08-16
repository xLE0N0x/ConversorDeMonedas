package dev.conversor.ui;

import com.google.gson.Gson;
import dev.conversor.model.Moneda;

public class Conversor {

    public static Moneda convertirDatos(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Moneda.class);
    }
}
