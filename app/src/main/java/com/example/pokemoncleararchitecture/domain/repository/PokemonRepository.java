package com.example.pokemoncleararchitecture.domain.repository;

import com.example.pokemoncleararchitecture.data.entity.PokemonResponse;

import io.reactivex.Single;

public interface PokemonRepository {
    Single<PokemonResponse> fetchPokemonList();
}
