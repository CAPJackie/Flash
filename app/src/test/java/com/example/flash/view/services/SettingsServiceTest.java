package com.example.flash.view.services;

import com.example.flash.model.SocialNetwork;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SettingsServiceTest {

    private SettingsService settingsService;



    @org.junit.jupiter.api.BeforeAll
    void setUp() {
        settingsService = SettingsService.getInstance();
        settingsService.setPreferredSocialNetworkList(Arrays.asList(new SocialNetwork("Twitter", 0),
                new SocialNetwork("Instagram", 1),
                new SocialNetwork("Linkedin", 2),
                new SocialNetwork("Hi5", 3)));

    }


    @Test
    public void itShouldChangeSocialNetworkPreferredListConfig(){
        List<SocialNetwork> preferredSocialNetworkListAfterChange = settingsService.getPreferredSocialNetworkList();
        preferredSocialNetworkListAfterChange.get(0).setChecked(false);
        preferredSocialNetworkListAfterChange.get(1).setChecked(false);


        settingsService.changeItemVisibility("Twitter");
        settingsService.changeItemVisibility("Instagram");
        List preferredSocialNetworkListFromService = settingsService.getPreferredSocialNetworkList();
        SocialNetwork[] preferredSocialNetworkListAfterChangeArray = (SocialNetwork[]) preferredSocialNetworkListAfterChange.toArray();
        SocialNetwork[] preferredSocialNetworkListFromServiceArray = (SocialNetwork[]) preferredSocialNetworkListFromService.toArray();
        Assert.assertArrayEquals(preferredSocialNetworkListAfterChangeArray, preferredSocialNetworkListFromServiceArray);
    }


}