package com.example.david0926.dreamtree.Graph;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.david0926.dreamtree.R;

import de.blox.graphview.BaseGraphAdapter;
import de.blox.graphview.Graph;
import de.blox.graphview.GraphView;
import de.blox.graphview.Node;
import de.blox.graphview.tree.BuchheimWalkerAlgorithm;
import de.blox.graphview.tree.BuchheimWalkerConfiguration;

public class GraphActivity extends AppCompatActivity{

    private int nodeCount = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        GraphView graphView = findViewById(R.id.graph);
        graphView.setLineColor(Color.parseColor("#1abc9c"));
        graphView.setLineThickness(2);

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
                viewHolder.graph_node.setText(data.toString());
            }
        };

        graphView.setAdapter(adapter);

        // set the algorithm here
        final BuchheimWalkerConfiguration configuration = new BuchheimWalkerConfiguration.Builder()
                .setSiblingSeparation(50)
                .setLevelSeparation(150)
                .setSubtreeSeparation(150)
                .setOrientation(BuchheimWalkerConfiguration.ORIENTATION_TOP_BOTTOM)
                .build();
        adapter.setAlgorithm(new BuchheimWalkerAlgorithm(configuration));

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
        return "Node " + nodeCount++;
    }
}
