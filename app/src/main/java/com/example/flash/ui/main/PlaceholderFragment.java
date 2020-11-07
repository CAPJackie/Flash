package com.example.flash.ui.main;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.flash.R;

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
//        PlaceholderFragment fragment = new PlaceholderFragment(index);
//        Bundle bundle = new Bundle();
//        bundle.putInt(ARG_SECTION_NUMBER, index);
//        fragment.setArguments(bundle);
        return new PlaceholderFragment(index);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        int index = 1;
//        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
//        if (getArguments() != null) {
//            index = getArguments().getInt(ARG_SECTION_NUMBER);
//        }
//        pageViewModel.setIndex(index);
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