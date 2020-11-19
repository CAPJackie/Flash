package com.jackie.flash.utils;

import com.jackie.flash.R;
import com.jackie.flash.models.entities.SocialNetwork;

import java.util.Arrays;
import java.util.List;

public class Constants {
    public static final List<SocialNetwork> SOCIAL_NETWORK_LIST = Arrays.asList(new SocialNetwork("Facebook",R.drawable.facebook_logo),
            new SocialNetwork("Instagram", R.drawable.instagram_logo),
            new SocialNetwork("Twitter", R.drawable.twitter_logo),
            new SocialNetwork("Linkedin", R.drawable.linkedin_logo));


}
