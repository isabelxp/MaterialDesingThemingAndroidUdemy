package com.capps.md_udemy.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.capps.md_udemy.R;
import com.capps.md_udemy.utils.Component;
import com.capps.md_udemy.utils.Constants;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class TextFieldFragment extends Fragment {

    public static final String TAG = "TextField";
    private static Component mInstance;
    Unbinder mUnbinder;


    @BindView(R.id.tilcapitalLetter)
    TextInputLayout tilcapitalLetter;

    @BindView(R.id.etCapitalLetter)
    TextInputEditText etCapitalLetter;


    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_textfields_outlined_active);
        mInstance.setType(Constants.SCROLL);

        return mInstance;
    }

    public TextFieldFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_text_field, container, false);
        mUnbinder = ButterKnife.bind(this, v);
        tilcapitalLetter.setEndIconOnClickListener(view1 -> {
            if(etCapitalLetter.getText() != null){
              String contentStr = etCapitalLetter.getText().toString();
              etCapitalLetter.setText(contentStr.toUpperCase());
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