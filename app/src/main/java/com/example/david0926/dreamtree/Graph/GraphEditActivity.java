package com.example.david0926.dreamtree.Graph;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.david0926.dreamtree.R;
import com.example.david0926.dreamtree.TabAdapter;

import java.util.ArrayList;

import de.blox.graphview.BaseGraphAdapter;
import de.blox.graphview.Graph;
import de.blox.graphview.GraphView;
import de.blox.graphview.Node;
import de.blox.graphview.tree.BuchheimWalkerAlgorithm;
import de.blox.graphview.tree.BuchheimWalkerConfiguration;

public class GraphEditActivity extends AppCompatActivity {




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editgraph);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TabLayout tabLayout = findViewById(R.id.tab_layout);

        View view1 = getLayoutInflater().inflate(R.layout.custom_tab, null);
        view1.findViewById(R.id.icon).setBackgroundResource(R.drawable.graphedit_indicator);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view1));

        View view2 = getLayoutInflater().inflate(R.layout.custom_tab, null);
        view2.findViewById(R.id.icon).setBackgroundResource(R.drawable.graphedit_indicator);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view2));

        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);

        final ViewPager pager = findViewById(R.id.pager_graphedit);

        final GraphEdit_TabAdapter adapter = new GraphEdit_TabAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        pager.setAdapter(adapter);

        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        pager.getRootView().setBackgroundColor(Color.WHITE);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });






    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
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


}
