package com.example.testretrojiankan.retrofit.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testretrojiankan.databinding.ActivityMainBinding;
import com.example.testretrojiankan.retrofit.retrofit.Anime;
import com.example.testretrojiankan.retrofit.retrofit.WebServices;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    static ActivityMainBinding binding;
    static String ricerca;

    public static void retrofitAnimeFinderDisara() {
        ricerca = binding.editView.getText().toString();

        if (ricerca.isEmpty()) ricerca = "naruto";
        Call<Anime> animeCall = WebServices.getInstance().createService().getAnime(ricerca);
        animeCall.enqueue(new Callback<Anime>() {
            @Override
            public void onResponse(Call<Anime> call, Response<Anime> response) {

                binding.textViewTitle.setText(response.body().getResults().get(0).getTitle());
                binding.textSipnasis.setText(response.body().getResults().get(0).getSynopsis());
                Picasso.get().load(response.body().getResults().get(0).getImageUrl()).into(binding.imageViewFrag);
            }

            @Override
            public void onFailure(Call<Anime> call, Throwable t) {

            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        binding.button.setOnClickListener(x -> {

            retrofitAnimeFinderDisara();
        });


    }


}