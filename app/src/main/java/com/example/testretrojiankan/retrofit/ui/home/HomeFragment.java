package com.example.testretrojiankan.retrofit.ui.home;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.testretrojiankan.databinding.FragmentHomeBinding;
import com.example.testretrojiankan.retrofit.AdapterNews;
import com.example.testretrojiankan.retrofit.retrofit.WebServices;
import com.example.testretrojiankan.retrofit.retrofit.Top_;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    AdapterNews adapterRecy;
    List<Top_> top_list;


    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
        final Call<List<Top_>> listCall = WebServices.getInstance().createService().getTopAnimesTopCall("anime", 2, "upcoming");


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapterRecy);

        listCall.enqueue(new Callback<List<Top_>>() {
            @Override
            public void onResponse(Call<List<Top_>> call, Response<List<Top_>> response) {
                top_list = new ArrayList<>();
                top_list = response.body();
                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "ok", Toast.LENGTH_SHORT).show();
                    Log.d("t",""+response.code());

                    adapterRecy.setTop_list(top_list);

                }
            }

            @Override
            public void onFailure(Call<List<Top_>> call, Throwable t) {

            }
        });
        return binding.getRoot();
    }
}
