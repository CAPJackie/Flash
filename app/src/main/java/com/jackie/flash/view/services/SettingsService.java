package com.jackie.flash.view.services;

import com.jackie.flash.models.SocialNetwork;

import java.util.ArrayList;
import java.util.List;

public class SettingsService {

    private static SettingsService instance = null;
    private List<SocialNetwork> preferredSocialNetworkList;


    private SettingsService() {
        this.preferredSocialNetworkList = new ArrayList<>();
    }

    public static SettingsService getInstance() {
        if(instance == null){
            instance= new SettingsService();
        }
        return instance;
    }

    public List<SocialNetwork> getPreferredSocialNetworkList() {
        return preferredSocialNetworkList;
    }

    public void changeItemVisibility(String socialNetworkName)  {
        try{
            SocialNetwork foundSocialNetwork = findSocialNetworkByName(socialNetworkName);
            foundSocialNetwork.setChecked(!foundSocialNetwork.isChecked());
        }catch(ServiceException e){
            System.out.println("Error");
        }


    }

    private SocialNetwork findSocialNetworkByName(String name) throws ServiceException{
        SocialNetwork foundSocialNetwork = null;
        for (SocialNetwork socialNetwork: this.preferredSocialNetworkList){
            if(socialNetwork.getName().equalsIgnoreCase(name)){
                foundSocialNetwork = socialNetwork;
            }
        }

        if (foundSocialNetwork.equals(null)) {
            throw new ServiceException(ServiceException.ERROR_NO_RESULTS);
        } else {
            return foundSocialNetwork;
        }
    }

    public void setPreferredSocialNetworkList(List<SocialNetwork> preferredSocialNetworkList) {
        this.preferredSocialNetworkList = preferredSocialNetworkList;
    }
}
