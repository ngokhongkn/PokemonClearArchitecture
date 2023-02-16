package com.example.pokemoncleararchitecture.domain.usecase;

import com.example.pokemoncleararchitecture.data.entity.PokemonResponse;
import com.example.pokemoncleararchitecture.domain.repository.PokemonRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class GetListPokemonUseCaseImpl implements GetListPokemonUseCase {
    private PokemonRepository pokemonRepository;

    @Inject
    public GetListPokemonUseCaseImpl(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public Single<PokemonResponse> excute() {
        return pokemonRepository.fetchPokemonList();
    }
}
