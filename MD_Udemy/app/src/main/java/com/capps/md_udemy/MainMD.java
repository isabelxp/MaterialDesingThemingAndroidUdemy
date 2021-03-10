package com.capps.md_udemy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.capps.md_udemy.adapter.ComponentAdapter;
import com.capps.md_udemy.fragments.BottomNavigationBarFragment;
import com.capps.md_udemy.fragments.ButtonFragment;
import com.capps.md_udemy.fragments.CardFragment;
import com.capps.md_udemy.fragments.FloatingFragment;
import com.capps.md_udemy.fragments.MotionFragment;
import com.capps.md_udemy.fragments.SnakbarFragment;
import com.capps.md_udemy.fragments.TextFieldFragment;
import com.capps.md_udemy.utils.Component;
import com.capps.md_udemy.utils.Constants;
import com.capps.md_udemy.utils.OnClickListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainMD extends AppCompatActivity implements OnClickListener {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private ComponentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_m_d);
        ButterKnife.bind(this);

        configAdapter();
        configRecyclerView();
    }

    private void configRecyclerView() {
        recyclerView.setAdapter(mAdapter);
    }

    private void configAdapter() {
        mAdapter = new ComponentAdapter(new ArrayList<>(), this);
        mAdapter.add(ButtonFragment.getmInstance());
        mAdapter.add(BottomNavigationBarFragment.getmInstance());
        mAdapter.add(SnakbarFragment.getmInstance());
        mAdapter.add(TextFieldFragment.getmInstance());
        mAdapter.add(FloatingFragment.getmInstance());
        mAdapter.add(MotionFragment.getmInstance());
        mAdapter.add(CardFragment.getmInstance()); }

    @Override
    public void onClick(Component component) {
        Intent intent;
        if (component.getType() == Constants.SCROLL){
            intent = new Intent(this, ScrollActivity.class);
        } else {
            intent = new Intent(this, StaticActivity.class);
        }
        intent.putExtra(Constants.ARG_NAME, component.getName());
        startActivity(intent);
    }
}