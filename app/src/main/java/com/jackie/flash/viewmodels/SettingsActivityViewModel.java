package com.jackie.flash.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jackie.flash.models.entities.SocialNetwork;
import com.jackie.flash.repositories.SocialNetworkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.jackie.flash.utils.Constants.SOCIAL_NETWORK_LIST;

public class SettingsActivityViewModel extends AndroidViewModel {

    private final LiveData<List<SocialNetwork>> socialNetworks;
    private SocialNetworkRepository socialNetworkRepository;

    private List<SocialNetwork> initialSocialNetworksState;

    public SettingsActivityViewModel(Application application) {
        super(application);
        socialNetworkRepository = new SocialNetworkRepository(application);
        socialNetworks = socialNetworkRepository.getSocialNetworks();
//        initialSocialNetworksState = socialNetworkRepository.getSocialNetworks();

    }

    public LiveData<List<SocialNetwork>> getSocialNetworks(){
        return socialNetworks;
    }



    public void update(SocialNetwork socialNetwork){
        SocialNetwork socialNetworkChanged = socialNetwork.clone();
        socialNetworkChanged.setChecked(!socialNetworkChanged.isChecked());
        socialNetworkChanged.setId(socialNetwork.getId());
        socialNetworkRepository.updateSocialNetwork(socialNetworkChanged);
    }



    public boolean validateForDataUpdates(List<SocialNetwork> socialNetworks) {
        boolean thereIsUpdates;

        if(initialSocialNetworksState == null){
            initialSocialNetworksState = new ArrayList<>();
            for (SocialNetwork socialNetwork:socialNetworks){
                initialSocialNetworksState.add(socialNetwork.clone());
            }

        }
        thereIsUpdates = !socialNetworks.equals(this.initialSocialNetworksState);


        return thereIsUpdates;
    }
}
