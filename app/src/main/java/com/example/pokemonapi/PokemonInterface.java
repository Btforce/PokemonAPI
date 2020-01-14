package com.example.pokemonapi;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonInterface {

    String Base_URL = "https://pokeapi.co/api/v2/";


    @GET("breed/{pokemon}/images/random")
    Call<Pokemon> getRandomImageByBreed(@Path("pokemon") String pokemon);

}
