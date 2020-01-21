package com.example.pokemonapi;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonInterface {

    String Base_URL = "https://pokeapi.co/api/v2/pokemon/";



    @GET("{number}/")
    Call<Pokemon> getRandomPokemon(@Path("number") String number);

}
