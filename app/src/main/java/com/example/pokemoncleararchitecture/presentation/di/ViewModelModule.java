package com.example.pokemoncleararchitecture.presentation.di;

import androidx.lifecycle.ViewModel;

import com.example.pokemoncleararchitecture.domain.usecase.GetListPokemonUseCase;
import com.example.pokemoncleararchitecture.presentation.viewmodel.MainViewModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import javax.inject.Provider;

import dagger.MapKey;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.components.SingletonComponent;
import dagger.multibindings.IntoMap;

@Module
@InstallIn(SingletonComponent.class)
public class ViewModelModule {
//    @Target(ElementType.METHOD)
//    @Retention(RetentionPolicy.RUNTIME)
//    @MapKey
//    @interface ViewModelKey {
//        Class<? extends ViewModel> value();
//    }

//    @Provides
//    HiltViewModelFactory viewModelFactory(Map<Class<? extends  ViewModel>, Provider<ViewModel>> providerMap) {
//        return new HiltViewModelFactory(providerMap);
//    }

    @Provides
//    @IntoMap
//    @ViewModelKey(MainViewModel.class)
    ViewModel mainViewModel(GetListPokemonUseCase getListPokemonUseCase) {
        return new MainViewModel(getListPokemonUseCase);
    }

}
