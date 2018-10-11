package com.example.david0926.dreamtree.Parse;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.david0926.dreamtree.R;


public class RecycleHolder_Parse extends RecyclerView.ViewHolder{

    public TextView word, name;

    public RecycleHolder_Parse(View itemView) {
        super(itemView);
        word = itemView.findViewById(R.id.parse_word);
        name = itemView.findViewById(R.id.parse_name);

    }
}
