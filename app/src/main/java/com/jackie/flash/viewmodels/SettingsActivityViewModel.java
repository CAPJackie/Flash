package com.jackie.flash.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jackie.flash.models.SocialNetwork;
import com.jackie.flash.repositories.SocialNetworkRepository;

import java.util.List;

public class SettingsActivityViewModel extends ViewModel {

    private MutableLiveData<List<SocialNetwork>> mSocialNetworks;
    private SocialNetworkRepository mSocialNetworkRepository;


    public void init(){
        if(mSocialNetworks != null){
            return;
        } else{
            mSocialNetworkRepository = SocialNetworkRepository.getInstance();
            mSocialNetworks = mSocialNetworkRepository.getSocialNetworks();
        }
    }

    public LiveData<List<SocialNetwork>> getSocialNetworks(){
        return mSocialNetworks;
    }
}
