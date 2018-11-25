package com.example.david0926.dreamtree.Graph;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class GraphEdit_TabAdapter extends FragmentPagerAdapter{

    private int num;

    public GraphEdit_TabAdapter(FragmentManager fm, int num) {
        super(fm);
        this.num = num;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                GraphEdit_Tab1 tab1 = new GraphEdit_Tab1();
                return tab1;

            case 1:
                GraphEdit_Tab2 tab2 = new GraphEdit_Tab2();
                return tab2;

            default: return null;

        }
    }

    @Override
    public int getCount() { //탭 개수 반환 함수
        return num;
    }
}
