package com.example.pokemonapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button randomButton;
    private TextView pokemonTextView;
    private PokemonInterface pokemonInterface;
    private EditText idNumberEditText;
    private int idNumber;
    private String idNumberString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PokemonInterface.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pokemonInterface = retrofit.create(PokemonInterface.class);



    }



    private void setListeners() {

        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idNumberString = idNumberEditText.getText().toString();
                if(!idNumberString.matches("")){
                    idNumber = Integer.parseInt(idNumberString);
                    getPokemonByIdNumber(idNumber);
                }
                else{
                    idNumber = (int)(Math.random()*806 + 1);
                    getPokemonByIdNumber(idNumber);
                }
                getPokemonByIdNumber(idNumber);
            }
        });

    }

    private void getPokemonByIdNumber(int idNumber) {
        Call<Pokemon> pokemonCall = pokemonInterface.getRandomPokemon(String.valueOf(idNumber));

        pokemonCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                //Any code that depends on the results of the search
                //has to go here



                Pokemon foundPokemon = response.body();
                //check if the body isn't null
                if (foundPokemon != null) {

                    Toast.makeText(MainActivity.this, foundPokemon.getName(), Toast.LENGTH_SHORT).show();

                    pokemonTextView.setText("Name: " + foundPokemon.getName() + "\n" +
                        "Height: " + foundPokemon.getHeight() + "\n" +
                        "Weight: " + foundPokemon.getWeight() + "\n" +
                        "Pokedex Number: " + foundPokemon.getId() + "\n"
                        );

                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                //Toast the failure
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void wireWidgets() {

        randomButton = findViewById(R.id.button_main_randomButton);
        pokemonTextView = findViewById(R.id.textView_main_pokemonInformation);
        idNumberEditText = findViewById(R.id.textView_main_pokemon);


    }
}
