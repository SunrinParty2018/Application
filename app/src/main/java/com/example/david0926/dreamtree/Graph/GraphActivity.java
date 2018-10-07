package com.example.david0926.dreamtree.Graph;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.david0926.dreamtree.R;

import java.util.ArrayList;
import java.util.List;

import de.blox.graphview.BaseGraphAdapter;
import de.blox.graphview.Graph;
import de.blox.graphview.GraphView;
import de.blox.graphview.Node;
import de.blox.graphview.tree.BuchheimWalkerAlgorithm;
import de.blox.graphview.tree.BuchheimWalkerConfiguration;
import pl.polidea.view.ZoomView;

public class GraphActivity extends AppCompatActivity{

    private int nodeCount = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GraphView graphView = findViewById(R.id.graph);
        graphView.setLineColor(Color.parseColor("#81C784"));
        graphView.setLineThickness(2);

        // example tree
        final Graph graph = new Graph();
//        ArrayList<String> table = new ArrayList<>();
//        ArrayList<String> connect = new ArrayList<>();
//        table.add("");
//        for(int i=0;i<10;i++){
//            graph.addEdge(new Node(getNodeTitle()), new Node(getNodeTitle()));
//        }

        final Node node1 = new Node(getNodeTitle());
        final Node node2 = new Node(getNodeTitle());
        final Node node3 = new Node(getNodeTitle());
        final Node node4 = new Node(getNodeTitle());
        final Node node5 = new Node(getNodeTitle());
        final Node node6 = new Node(getNodeTitle());
        final Node node8 = new Node(getNodeTitle());
        final Node node7 = new Node(getNodeTitle());
        final Node node9 = new Node(getNodeTitle());
        final Node node10 = new Node(getNodeTitle());
        final Node node11 = new Node(getNodeTitle());
        final Node node12 = new Node(getNodeTitle());

        graph.addEdge(node1, node2);
        graph.addEdge(node1, node3);
        graph.addEdge(node1, node4);
        graph.addEdge(node2, node5);
        graph.addEdge(node2, node6);
        graph.addEdge(node6, node7);
        graph.addEdge(node6, node8);
        graph.addEdge(node4, node9);
        graph.addEdge(node4, node10);
        graph.addEdge(node4, node11);
        graph.addEdge(node11, node12);

        Adapter_Graph adapter = new Adapter_Graph(this, R.layout.graph_node, graph);
        graphView.setAdapter(adapter);

        Model_Graph model = new Model_Graph();
        model.setTitle("title");
        model.setMsg("msg");
        model.setNode(1);
        model.setConnect(1);
        adapter.addNode(model);




        // set the algorithm here
        final BuchheimWalkerConfiguration configuration = new BuchheimWalkerConfiguration.Builder()
                .setSiblingSeparation(25)
                .setLevelSeparation(150)
                .setSubtreeSeparation(150)
                .setOrientation(BuchheimWalkerConfiguration.ORIENTATION_TOP_BOTTOM)
                .build();
        adapter.setAlgorithm(new BuchheimWalkerAlgorithm(configuration));


        //zoomview

//        View v = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.activity_graph, null, false);
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
//
//        ZoomView zoomView = new ZoomView(this);
//        zoomView.addView(v);
//        zoomView.setLayoutParams(layoutParams);
//        RelativeLayout container = (RelativeLayout) findViewById(R.id.container);
//        container.addView(zoomView);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
            default:
                return true;
        }
    }

    private String getNodeTitle() {
        nodeCount++;
        return nodeCount+"단계 목표";
    }
    private String getNodeMsg() {
        return nodeCount+"단계 메세지";
    }
}
