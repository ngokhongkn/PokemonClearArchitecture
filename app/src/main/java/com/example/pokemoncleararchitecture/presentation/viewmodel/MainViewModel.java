package com.example.pokemoncleararchitecture.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pokemoncleararchitecture.data.entity.PokemonResponse;
import com.example.pokemoncleararchitecture.domain.usecase.GetListPokemonUseCase;
import com.example.pokemoncleararchitecture.presentation.model.Resource;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private GetListPokemonUseCase getListPokemonUseCase;
    private MutableLiveData<Resource<PokemonResponse>> pokemonList = new MutableLiveData<>();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    public MainViewModel(GetListPokemonUseCase getListPokemonUseCase) {
        this.getListPokemonUseCase = getListPokemonUseCase;
    }

    public void fetchPokemonList() {
        pokemonList.postValue(Resource.loading());
        compositeDisposable.add(getListPokemonUseCase.excute().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(pokemonResponse -> {
                    pokemonList.setValue(Resource.success(pokemonResponse));
                }, throwable -> {
                    pokemonList.setValue(Resource.error(throwable.getMessage()));
                }));
    }

    public LiveData<Resource<PokemonResponse>> getPokemonList() {
        return pokemonList;
    }
}
