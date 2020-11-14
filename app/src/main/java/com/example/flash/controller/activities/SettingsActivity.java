package com.example.flash.controller.activities;

import android.os.Bundle;

import com.example.flash.adapters.SocialNetworkAdapter;
import com.example.flash.models.SocialNetwork;
import com.example.flash.utils.Constants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;

import com.example.flash.R;
import com.example.flash.viewmodels.SettingsActivityViewModel;

import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    private Button applyButton;
    private Button cancelButton;
    private RecyclerView recyclerView;
    private SocialNetworkAdapter socialNetworkAdapter;
    private SettingsActivityViewModel mSettingsActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();


    }

    private void init() {
        applyButton = findViewById(R.id.apply_button);
        cancelButton = findViewById(R.id.cancel_button);
        recyclerView = findViewById(R.id.social_network_list);


        applyButton.setEnabled(false);
        cancelButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });



        mSettingsActivityViewModel = ViewModelProviders.of(this).get(SettingsActivityViewModel.class);

        mSettingsActivityViewModel.init();

        mSettingsActivityViewModel.getSocialNetworks().observe(this, new Observer<List<SocialNetwork>>() {
            @Override
            public void onChanged(List<SocialNetwork> socialNetworks) {
                socialNetworkAdapter.notifyDataSetChanged();
            }
        });

        initRecyclerView();

    }

    private void initRecyclerView() {
        socialNetworkAdapter = new SocialNetworkAdapter(mSettingsActivityViewModel.getSocialNetworks().getValue());
        recyclerView.setAdapter(socialNetworkAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}