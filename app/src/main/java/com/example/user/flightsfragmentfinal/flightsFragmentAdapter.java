package com.example.user.flightsfragmentfinal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by user on 3/1/2018.
 */

public class flightsFragmentAdapter extends FragmentPagerAdapter {
    public flightsFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new BlankFragment();
            case 1:
                return new OneWay();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "ROUNDTRIP";
            case 1:
                return "ONEWAY";
        }
        return super.getPageTitle(position);
    }
}
