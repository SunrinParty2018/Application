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

import de.blox.graphview.BaseGraphAdapter;
import de.blox.graphview.Graph;
import de.blox.graphview.GraphView;
import de.blox.graphview.Node;
import de.blox.graphview.tree.BuchheimWalkerAlgorithm;
import de.blox.graphview.tree.BuchheimWalkerConfiguration;
import pl.polidea.view.ZoomView;

public class GraphActivity extends AppCompatActivity{

    private int nodeCount = 0;
    ArrayList<String> NodeMsg = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GraphView graphView = findViewById(R.id.graph);
        graphView.setLineColor(Color.parseColor("#81C784"));
        graphView.setLineThickness(2);
        NodeMsg.add(getString(R.string.node1));
        NodeMsg.add(getString(R.string.node2));
        NodeMsg.add(getString(R.string.node3));
        NodeMsg.add(getString(R.string.node4));
        NodeMsg.add(getString(R.string.node5));
        NodeMsg.add(getString(R.string.node6));
        NodeMsg.add(getString(R.string.node7));
        NodeMsg.add(getString(R.string.node8));
        NodeMsg.add(getString(R.string.node9));
        NodeMsg.add(getString(R.string.node10));
        NodeMsg.add(getString(R.string.node11));
        NodeMsg.add(getString(R.string.node12));



        // example tree
        final Graph graph = new Graph();
        final Node node1 = new Node(getNodeText());
        final Node node2 = new Node(getNodeText());
        final Node node3 = new Node(getNodeText());
        final Node node4 = new Node(getNodeText());
        final Node node5 = new Node(getNodeText());
        final Node node6 = new Node(getNodeText());
        final Node node8 = new Node(getNodeText());
        final Node node7 = new Node(getNodeText());
        final Node node9 = new Node(getNodeText());
        final Node node10 = new Node(getNodeText());
        final Node node11 = new Node(getNodeText());
        final Node node12 = new Node(getNodeText());

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


        final BaseGraphAdapter<Holder_Graph> adapter = new BaseGraphAdapter<Holder_Graph>(this, R.layout.graph_node, graph) {
            @NonNull
            @Override
            public Holder_Graph onCreateViewHolder(View view) {
                return new Holder_Graph(view);
            }

            @Override
            public void onBindViewHolder(Holder_Graph viewHolder, Object data, int position) {
                viewHolder.node_msg.setText(data.toString());
            }
        };

        graphView.setAdapter(adapter);

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

    private String getNodeText() {
        return NodeMsg.get(nodeCount++);
    }
}
