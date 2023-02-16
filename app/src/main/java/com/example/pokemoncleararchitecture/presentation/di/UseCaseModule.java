package com.example.pokemoncleararchitecture.presentation.di;

import com.example.pokemoncleararchitecture.domain.repository.PokemonRepository;
import com.example.pokemoncleararchitecture.domain.usecase.GetListPokemonUseCase;
import com.example.pokemoncleararchitecture.domain.usecase.GetListPokemonUseCaseImpl;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class UseCaseModule {
    @Provides
    GetListPokemonUseCase provideGetListPokemonUseCase(PokemonRepository pokemonRepository) {
        return new GetListPokemonUseCaseImpl(pokemonRepository);
    }
}
