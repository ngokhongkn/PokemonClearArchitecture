package com.example.pokemoncleararchitecture.data.entity;

import com.google.gson.annotations.SerializedName;

public class Pokemon {
    @SerializedName("name")
    public String name;
    @SerializedName("url")
    public String url;

    public String getImageUrl() {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png";
    }
}
