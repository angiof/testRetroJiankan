package com.example.testretrojiankan.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.testretrojiankan.databinding.RecyNewsItemsListBinding;
import com.example.testretrojiankan.retrofit.retrofit.Top_;

import java.util.List;


public class AdapterNews extends RecyclerView.Adapter<AdapterNews.CLassHolder> {
    private List<Top_> top_list;
    Context context;



    public void setTop_list(List<Top_> top_list ) {
        this.top_list = top_list;
    }

    @Override
    public AdapterNews.CLassHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new CLassHolder(RecyNewsItemsListBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));


    }

    @Override
    public void onBindViewHolder(@NonNull AdapterNews.CLassHolder holder, int position) {
        Top_ tops = top_list.get(position);
        holder.itemsListBinding.texViewTops.setText(tops.getTitle());
        Glide.with(context).load(tops.getImageUrl()).apply(RequestOptions.centerCropTransform()).into(holder.imageView);


    }


    @Override
    public int getItemCount() {
        return top_list.size();
    }

    public class CLassHolder extends RecyclerView.ViewHolder {
        RecyNewsItemsListBinding itemsListBinding;
        TextView textView;
        ImageView imageView;

        public CLassHolder(@NonNull RecyNewsItemsListBinding itemsListBinding) {
            super(itemsListBinding.getRoot());
            this.itemsListBinding = itemsListBinding;
            textView = itemsListBinding.texViewTops;
            imageView = itemsListBinding.imageViewTops;

        }
    }
}
