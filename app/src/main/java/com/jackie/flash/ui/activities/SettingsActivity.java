package com.jackie.flash.ui.activities;

import android.os.Bundle;

import com.jackie.flash.adapters.SocialNetworkAdapter;
import com.jackie.flash.models.entities.SocialNetwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;

import com.jackie.flash.R;
import com.jackie.flash.viewmodels.SettingsActivityViewModel;

import java.util.List;

import static com.jackie.flash.utils.Constants.SOCIAL_NETWORK_LIST;

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
        cancelButton.setOnClickListener(v -> finish());



        mSettingsActivityViewModel = new ViewModelProvider(this).get(SettingsActivityViewModel.class);
        mSettingsActivityViewModel.getSocialNetworks().observe(this, socialNetworks -> {
            socialNetworkAdapter.setSocialNetworkList(socialNetworks);
            if(mSettingsActivityViewModel.validateForDataUpdates(socialNetworks)){
                applyButton.setEnabled(true);
            } else{
                applyButton.setEnabled(false);
            }

//            socialNetworkAdapter.notifyDataSetChanged();
        });

        initRecyclerView();

    }

    private void initRecyclerView() {
        socialNetworkAdapter = new SocialNetworkAdapter(mSettingsActivityViewModel);
        recyclerView.setAdapter(socialNetworkAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}