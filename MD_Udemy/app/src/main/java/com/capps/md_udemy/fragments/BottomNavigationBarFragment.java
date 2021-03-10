package com.capps.md_udemy.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.capps.md_udemy.R;
import com.capps.md_udemy.utils.Component;
import com.capps.md_udemy.utils.Constants;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class BottomNavigationBarFragment extends Fragment {


    public static final String TAG = "Botton Navigation";
    private static Component mInstance;
    Unbinder mUnbinder;

    @BindView(R.id.bottomNavigation)
    BottomNavigationView bottomNavigation;


    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_bottomnav_mobile_portrait);
        mInstance.setType(Constants.STATIC);

        return mInstance;
    }

    public BottomNavigationBarFragment() {
        // Required empty public constructor
    }


    /*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
   */


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_bottom_navigation_bar, container, false);
        mUnbinder = ButterKnife.bind(this, v);
        bottomNavigation.getOrCreateBadge(R.id.action_start);
        //bottomNavigation.removeBadge(R.id.action_start);

        BadgeDrawable favoriteBadge = bottomNavigation.getOrCreateBadge(R.id.action_favorites);
        favoriteBadge.setNumber(21);

        BadgeDrawable profileBadge = bottomNavigation.getOrCreateBadge(R.id.action_profile);
        profileBadge.setNumber(10000);
        profileBadge.setBackgroundColor(Color.CYAN);
        profileBadge.setBadgeTextColor(Color.MAGENTA);
        //profileBadge.setMaxCharacterCount(3);

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}