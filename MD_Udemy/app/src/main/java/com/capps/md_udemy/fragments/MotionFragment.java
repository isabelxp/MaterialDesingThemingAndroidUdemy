package com.capps.md_udemy.fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.transition.TransitionManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.capps.md_udemy.R;
import com.capps.md_udemy.utils.Component;
import com.capps.md_udemy.utils.Constants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.transition.MaterialContainerTransform;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MotionFragment extends Fragment {

    public static final String TAG = "Motion";
    private static Component mInstance;
    Unbinder mUnbinder;

    @BindView(R.id.containerMain)
    CoordinatorLayout containerMain;
    @BindView(R.id.viewEnd)
    ConstraintLayout viewEnd;
    @BindView(R.id.viewStart)
    FloatingActionButton viewStart;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_motion);
        mInstance.setType(Constants.STATIC);
        return mInstance;
    }



    public MotionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_motion, container, false);
        mUnbinder = ButterKnife.bind(this, v);

        viewStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialContainerTransform transform = new MaterialContainerTransform();
                transform.setScrimColor(Color.TRANSPARENT);
                transform.setDuration(2500L);
                transform.setStartView(viewStart);
                transform.setEndView(viewEnd);
                TransitionManager.beginDelayedTransition(containerMain, transform);
                viewStart.setVisibility(View.GONE);
                viewEnd.setVisibility(View.VISIBLE);
            }
        });

        return v;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}