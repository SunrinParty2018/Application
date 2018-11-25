package com.example.david0926.dreamtree.Graph;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.david0926.dreamtree.R;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

import de.blox.graphview.BaseGraphAdapter;
import de.blox.graphview.Graph;
import de.blox.graphview.GraphView;
import de.blox.graphview.Node;
import de.blox.graphview.tree.BuchheimWalkerAlgorithm;
import de.blox.graphview.tree.BuchheimWalkerConfiguration;


public class Tab_Graph extends android.support.v4.app.Fragment {

    public static Tab_Graph newInstance(){
        Tab_Graph fragment = new Tab_Graph();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.tab_graph, container, false);

        LinearLayout newNodeBtn = v.findViewById(R.id.btn_newnode);

        newNodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), GraphEditActivity.class));
            }
        });

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fab_graph);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), GraphActivity.class));
            }
        });



        return v;
    }



}

