package com.capps.md_udemy.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.capps.md_udemy.R;
import com.capps.md_udemy.utils.Component;
import com.capps.md_udemy.utils.Constants;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CardFragment extends Fragment {


    public static final String TAG = "Card";
    private static Component mInstance;
    Unbinder mUnbinder;

    @BindView(R.id.imgCardLarge)
    ImageView imgCardLarge;

    public static Component getmInstance(){
        mInstance = new Component();
        mInstance.setName(TAG);
        mInstance.setPhotoRes(R.drawable.img_cards_template);
        mInstance.setType(Constants.SCROLL);
        return mInstance;
    }

    public CardFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_card, container, false);
        mUnbinder = ButterKnife.bind(this, view);

         RequestOptions options = new RequestOptions()
                 .diskCacheStrategy(DiskCacheStrategy.ALL)
                 .centerCrop();

                Glide
                .with(view)
                .load("https://www.vivafutbol.es/mytvshows/wp-content/uploads/2017/03/frases-bonitas.jpg")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .apply(options)
                .into(imgCardLarge);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }
}