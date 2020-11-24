package com.jackie.flash.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jackie.flash.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {


    private int socialMedia;
    private ImageView socialMediaLogoView;

    public int getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(int socialMedia) {
        this.socialMedia = socialMedia;
    }

    public PlaceholderFragment(int socialMediaLogo) {
        this.socialMedia = socialMediaLogo;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        socialMediaLogoView = root.findViewById(R.id.social_media_logo);

        socialMediaLogoView.setImageResource(this.socialMedia);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("Prueba resume" + this.socialMedia);
    }
}