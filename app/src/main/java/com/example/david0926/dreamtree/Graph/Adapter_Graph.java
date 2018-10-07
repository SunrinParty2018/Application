package com.example.david0926.dreamtree.Graph;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import de.blox.graphview.BaseGraphAdapter;
import de.blox.graphview.Graph;

public class Adapter_Graph extends BaseGraphAdapter<Holder_Graph>{

    List<Model_Graph> items = new ArrayList<>();

    public Adapter_Graph(@NonNull Context context, int layoutRes, @NonNull Graph graph) {
        super(context, layoutRes, graph);
    }

    public void addNode(Model_Graph data){
        items.add(data);
    }



    @NonNull
    @Override
    public Holder_Graph onCreateViewHolder(View view) {
        return new Holder_Graph(view);
    }

    @Override
    public void onBindViewHolder(Holder_Graph viewHolder, Object data, int position) {
        Model_Graph item = items.get(position);
        viewHolder.node_title.setText(item.getTitle());
        viewHolder.node_msg.setText(item.getMsg());
    }

}
