package com.example.david0926.dreamtree.Parse;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.david0926.dreamtree.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter_Parse extends RecyclerView.Adapter<RecycleHolder_Parse> {

    public List<RecycleModel_Parse> getItems() {
        return items;
    }

    List<RecycleModel_Parse> items = new ArrayList<>();

    public void add(RecycleModel_Parse data){
        items.add(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecycleHolder_Parse onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_item_parse, parent, false);
        return new RecycleHolder_Parse(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleHolder_Parse holder, int position) {
        RecycleModel_Parse item = items.get(position);
        holder.name.setText(item.getName());
        holder.word.setText(item.getWord());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
