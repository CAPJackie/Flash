package com.example.flash.ui.activities;

import android.os.Bundle;

import com.example.flash.adapters.SocialNetworkAdapter;
import com.example.flash.utils.Constants;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;

import com.example.flash.R;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();


    }

    private void init() {
        Button applyButton = findViewById(R.id.apply_button);
        Button cancelButton = findViewById(R.id.cancel_button);
        RecyclerView recyclerView = findViewById(R.id.social_network_list);


        applyButton.setEnabled(false);
        cancelButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        SocialNetworkAdapter socialNetworkAdapter = new SocialNetworkAdapter(Constants.SOCIAL_NETWORK_LIST);
        recyclerView.setAdapter(socialNetworkAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}