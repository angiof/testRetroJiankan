package com.example.testretrojiankan.retrofit.retrofit;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebApis {


    @GET("search/anime")
    Call<Anime> getAnime(@Query("q") String query);

    @GET("top/anime/1/upcoming")
    Call<List<Top_>> getTopAnimesTopCall(@Query("type" )String type,
                                         @Query("page")int page,
                                         @Query("subtype")String subtype);



}

