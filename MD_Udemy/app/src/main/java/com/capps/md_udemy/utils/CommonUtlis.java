package com.capps.md_udemy.utils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.capps.md_udemy.fragments.BottomNavigationBarFragment;
import com.capps.md_udemy.fragments.ButtonFragment;
import com.capps.md_udemy.fragments.CardFragment;
import com.capps.md_udemy.fragments.FloatingFragment;
import com.capps.md_udemy.fragments.MotionFragment;
import com.capps.md_udemy.fragments.SnakbarFragment;
import com.capps.md_udemy.fragments.TextFieldFragment;

public class CommonUtlis {
    public static void setFragment(AppCompatActivity activity, String nameFragment, int contentRes){
        Fragment fragment = getFragmentById(nameFragment);
        activity.getSupportFragmentManager().beginTransaction()
                .add(contentRes, fragment)
                .commit(); }

    private static Fragment getFragmentById(String nameFragment) {
        Fragment fragment = null;

        switch (nameFragment){
            case ButtonFragment.TAG:
                fragment = new ButtonFragment();
                break;
            case BottomNavigationBarFragment.TAG:
                fragment = new BottomNavigationBarFragment();
                break;
            case SnakbarFragment.TAG:
                fragment = new SnakbarFragment();
                break;
            case TextFieldFragment.TAG:
                fragment = new TextFieldFragment();
                break;
            case FloatingFragment.TAG:
                fragment = new FloatingFragment();
                break;
            case CardFragment.TAG:
                fragment = new CardFragment();
                break;
            case MotionFragment.TAG:
                fragment = new MotionFragment();
                break; }
        return fragment;
    }
}
