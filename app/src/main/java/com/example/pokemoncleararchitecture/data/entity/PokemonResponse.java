package com.example.pokemoncleararchitecture.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonResponse {
    @SerializedName("count")
    public int count;
    @SerializedName("next")
    public String next;
    @SerializedName("previous")
    public String previous;
    @SerializedName("results")
    public List<Pokemon> results;
}
