package com.example.pokemoncleararchitecture.data.api;

import com.example.pokemoncleararchitecture.data.entity.PokemonResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonApi {
    @GET("pokemon")
    Single<PokemonResponse> fetchPokemonList(@Query("limit") int limit,
                                             @Query("offset") int offset);
}
