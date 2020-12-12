package com.example.testretrojiankan.retrofit.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testretrojiankan.databinding.AnimeFragLayoutBinding;


public class Frag_Anime extends Fragment {
    AnimeFragLayoutBinding layoutBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        layoutBinding=AnimeFragLayoutBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment



         /*

        Call<Anime> animeCall = WebServices.getInstance().createService().getAnime("boruto next generation");
        animeCall.enqueue(new Callback<Anime>() {
            @Override
            public void onResponse(Call<Anime> call, Response<Anime> response) {

                layoutBinding.textViewTitle.setText(response.body().getResults().get(0).getTitle());
                Picasso.get().load(response.body().getResults().get(0).getImageUrl()).into(layoutBinding.imageViewFrag);
            }

            @Override
            public void onFailure(Call<Anime> call, Throwable t) {

            }
        });
        Call<List<Top_>> animeTop =WebServices.getInstance().createService().getTopAnimesTopCall("anime",2,"upcoming");

        animeTop.enqueue(new Callback<List<Top_>>() {
            @Override
            public void onResponse(Call<List<Top_>> call, Response<List<Top_>> response) {

                if (response.isSuccessful()){
                    Log.d("t",""+response.code());
                    Log.d("oo",""+response.body().get(0).getScore());
                }

            }

            @Override
            public void onFailure(Call<List<Top_>> call, Throwable t) {

            }
        });

    */


        return  layoutBinding.getRoot();
    }
}