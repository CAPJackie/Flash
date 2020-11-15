package com.jackie.flash.controller.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jackie.flash.R;
import com.jackie.flash.view.PageViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public int getSocialMediaType() {
        return socialMediaType;
    }

    public void setSocialMediaType(int socialMediaType) {
        this.socialMediaType = socialMediaType;
    }

    private int socialMediaType;


    public PlaceholderFragment(int socialMediaType) {
        this.socialMediaType = socialMediaType;
    }

    public static PlaceholderFragment newInstance(int index) {
        return new PlaceholderFragment(index);
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
        ImageView socialMediaLogo = root.findViewById(R.id.social_media_logo);

        Resources resources = root.getResources();
        if (resources.getInteger(R.integer.facebook) == this.socialMediaType){
            socialMediaLogo.setImageResource(R.drawable.facebook_logo);
        } else if(resources.getInteger(R.integer.instagram) == this.socialMediaType){
            socialMediaLogo.setImageResource(R.drawable.instagram_logo);

        }
        else if(resources.getInteger(R.integer.twitter) == this.socialMediaType){
            socialMediaLogo.setImageResource(R.drawable.twitter_logo);

        }
        else if(resources.getInteger(R.integer.linkedin) == this.socialMediaType){
            socialMediaLogo.setImageResource(R.drawable.linkedin_logo);

        }
        else{
            socialMediaLogo.setImageResource(R.drawable.facebook_logo);
        }

        return root;
    }
}