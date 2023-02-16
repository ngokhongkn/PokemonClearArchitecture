package com.example.pokemoncleararchitecture;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.pokemoncleararchitecture.data.entity.PokemonResponse;
import com.example.pokemoncleararchitecture.presentation.model.Resource;
import com.example.pokemoncleararchitecture.presentation.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mainViewModel.fetchPokemonList();

        mainViewModel.getPokemonList().observe(this, new Observer<Resource<PokemonResponse>>() {
            @Override
            public void onChanged(Resource<PokemonResponse> pokemonResponseResource) {
                switch (pokemonResponseResource.getStatus()) {
                    case SUCCESS:
                        Toast.makeText(MainActivity.this, pokemonResponseResource.getStatus().toString(), Toast.LENGTH_SHORT).show();
                        Log.d("DungTest", "onChanged: SUCCESS " + pokemonResponseResource.getData().results.size());
                        break;
                    case ERROR:
                        Log.d("DungTest", "onChanged: ERROR " + pokemonResponseResource.getMessage());
                        break;
                    case LOADING:
                        Log.d("DungTest", "onChanged: LOADING ");
                        break;
                }

            }
        });

    }
}