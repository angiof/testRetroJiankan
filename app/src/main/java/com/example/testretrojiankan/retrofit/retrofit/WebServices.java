package com.example.testretrojiankan.retrofit.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServices {

    private static final String BASE_URL = "https://api.jikan.moe/v3/";
    private static WebServices instance;
    private Retrofit retrofit;
    private final HttpLoggingInterceptor looggingInterceptor;
    private final OkHttpClient.Builder httPclientBuilder;


    public WebServices() {
        looggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httPclientBuilder = new OkHttpClient.Builder().addInterceptor(looggingInterceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(httPclientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                //   .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static synchronized WebServices getInstance() {
        if (instance == null) {
            instance = new WebServices();
        }

        return instance;
    }


    public WebApis createService() {
        return retrofit.create(WebApis.class);
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }
}
