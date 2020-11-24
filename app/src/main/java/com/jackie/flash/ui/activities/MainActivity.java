package com.jackie.flash.ui.activities;

import android.content.Intent;
import android.os.Bundle;

import com.jackie.flash.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.jackie.flash.adapters.SectionsPagerAdapter;
import com.jackie.flash.models.entities.SocialNetwork;
import com.jackie.flash.viewmodels.SettingsActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SettingsActivityViewModel mSettingsActivityViewModel;
    private SectionsPagerAdapter sectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        setViewPagerConfig();
        setActionListeners();
        mSettingsActivityViewModel = new ViewModelProvider(this).get(SettingsActivityViewModel.class);
        mSettingsActivityViewModel.getSocialNetworks().observe(this, socialNetworks -> {
            List<SocialNetwork> visibleSocialNetworks = new ArrayList<>();
            for (SocialNetwork sn: socialNetworks){
                if(sn.isChecked()){
                    visibleSocialNetworks.add(sn.clone());
                }
            }
            sectionsPagerAdapter.setSocialNetworkList(visibleSocialNetworks);

            sectionsPagerAdapter.notifyDataSetChanged();

        });
    }

    private void setViewPagerConfig() {
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    private void setActionListeners() {
        FloatingActionButton settingsButton = findViewById(R.id.settings_button);

        settingsButton.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), SettingsActivity.class);
            startActivity(intent);

        });
    }
}