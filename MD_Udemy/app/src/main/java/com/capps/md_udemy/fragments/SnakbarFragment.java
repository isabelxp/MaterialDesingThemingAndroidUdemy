package com.capps.md_udemy.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.capps.md_udemy.R;
import com.capps.md_udemy.utils.Component;
import com.capps.md_udemy.utils.Constants;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SnakbarFragment extends Fragment {


    public SnakbarFragment() {
        // Required empty public constructor
    }

    @BindView(R.id.containerMain)
    FrameLayout containerMain;

    public static final String TAG = "SnakBar";
    private static Component mInstance;
    Unbinder mUnbinder;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_singleline_action);
        mInstance.setType(Constants.STATIC);

        return mInstance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_snakbar, container, false);
        mUnbinder = ButterKnife.bind(this, v);

        Snackbar.make(containerMain, R.string.message_action_success, Snackbar.LENGTH_LONG)
                .setAction("Volver", view -> getActivity().finish())
                .show();


        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}