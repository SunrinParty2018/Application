package com.example.david0926.dreamtree.TreeGrow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.david0926.dreamtree.R;


public class Tab_TreeGrow extends android.support.v4.app.Fragment{

    private static int i=0;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        final View v =  inflater.inflate(R.layout.tab_treegrow, container, false);

        ImageView imageView = v.findViewById(R.id.imageview_treegrow);
        imageView.setImageResource(R.drawable.tree1);

        Button button = v.findViewById(R.id.btn_treegrow);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = v.findViewById(R.id.imageview_treegrow);
                i++;
                switch (i){
                    case 1:
                        imageView.setImageResource(R.drawable.tree1);
                    case 2:
                        imageView.setImageResource(R.drawable.tree2);
                    case 3:
                        imageView.setImageResource(R.drawable.tree3);
                    case 4:
                        imageView.setImageResource(R.drawable.tree4);
                    case 5:
                        imageView.setImageResource(R.drawable.tree5);
                    default:
                        i=0;
                }

            }
        });

        return v;
    }
}
