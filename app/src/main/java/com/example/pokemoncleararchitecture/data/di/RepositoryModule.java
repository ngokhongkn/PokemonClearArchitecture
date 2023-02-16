package com.example.pokemoncleararchitecture.data.di;

import com.example.pokemoncleararchitecture.data.PokemonRepositoryImpl;
import com.example.pokemoncleararchitecture.data.api.PokemonApi;
import com.example.pokemoncleararchitecture.domain.repository.PokemonRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RepositoryModule {
    @Provides
    PokemonRepository providePokemonRepository(PokemonApi pokemonApi) {
        return new PokemonRepositoryImpl(pokemonApi);
    }
}
