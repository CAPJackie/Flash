package com.jackie.flash.adapters;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.jackie.flash.R;
import com.jackie.flash.models.entities.SocialNetwork;
import com.jackie.flash.ui.fragments.PlaceholderFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final Context mContext;
    private List<SocialNetwork> socialNetworkList;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
        socialNetworkList = new ArrayList<>();
    }

    public void setSocialNetworkList(List<SocialNetwork> socialNetworkList) {
        this.socialNetworkList = socialNetworkList;
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //TODO Refactorize with a fragment file for each one
        System.out.println("POSITION"+position + " icon" + socialNetworkList.get(position).getIcon() + "NAME" + socialNetworkList.get(position).getName());
        return new PlaceholderFragment(socialNetworkList.get(position).getIcon());
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        //NOT WORKING
        return POSITION_NONE;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return socialNetworkList.get(position).getName();
    }



    @Override
    public int getCount() {
        return socialNetworkList.size();
    }


}