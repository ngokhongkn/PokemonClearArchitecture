package com.example.pokemoncleararchitecture.domain.usecase;

import com.example.pokemoncleararchitecture.data.entity.PokemonResponse;

import io.reactivex.Single;

public interface GetListPokemonUseCase {
    Single<PokemonResponse> excute();
}
