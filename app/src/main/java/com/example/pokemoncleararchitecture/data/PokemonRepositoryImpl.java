package com.example.pokemoncleararchitecture.data;

import com.example.pokemoncleararchitecture.data.api.PokemonApi;
import com.example.pokemoncleararchitecture.data.entity.PokemonResponse;
import com.example.pokemoncleararchitecture.domain.repository.PokemonRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class PokemonRepositoryImpl implements PokemonRepository {
    private PokemonApi pokemonApi;

    @Inject
    public PokemonRepositoryImpl(PokemonApi pokemonApi) {
        this.pokemonApi = pokemonApi;
    }

    @Override
    public Single<PokemonResponse> fetchPokemonList() {
        return pokemonApi.fetchPokemonList(20, 0);
    }
}
