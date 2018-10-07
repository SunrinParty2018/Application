package com.example.david0926.dreamtree;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.david0926.dreamtree.Graph.Tab_Graph;
import com.example.david0926.dreamtree.Parse.Tab_Parse;
import com.example.david0926.dreamtree.TreeGrow.Tab_TreeGrow;


public class TabAdapter extends FragmentStatePagerAdapter{

    int tabNum;

    public TabAdapter(FragmentManager fm, int tabNum) {
        super(fm);
        this.tabNum = tabNum;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                Tab_TreeGrow tab1 = new Tab_TreeGrow();
                return tab1;
            case 1:
                Tab_Graph tab2 = new Tab_Graph();
                return tab2;
            case 2:
                Tab_Parse tab3 = new Tab_Parse();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabNum;
    }
}
