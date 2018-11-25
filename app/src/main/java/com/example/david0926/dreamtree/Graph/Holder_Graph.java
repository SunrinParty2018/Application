package com.example.david0926.dreamtree.Graph;

import android.view.View;
import android.widget.TextView;

import com.example.david0926.dreamtree.R;


public class Holder_Graph {

    TextView node_title, node_msg;
    Holder_Graph(View v) {
        node_title = v.findViewById(R.id.node_title);
        node_msg = v.findViewById(R.id.node_msg);
    }

}
