package com.example.david0926.dreamtree.TreeGrow;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.david0926.dreamtree.R;


public class Tab_TreeGrow extends android.support.v4.app.Fragment{

    private int i=0;

    public static Tab_TreeGrow newInstance(){
        Tab_TreeGrow fragment = new Tab_TreeGrow();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        final View v =  inflater.inflate(R.layout.tab_treegrow, container, false);

        ImageView imageView = v.findViewById(R.id.imageview_treegrow);
        imageView.setImageResource(R.drawable.tree3);

        return v;
    }
}
