package com.jackie.flash.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jackie.flash.models.entities.SocialNetwork;
import com.jackie.flash.repositories.SocialNetworkRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Refactor name to SocialNetworkViewModel
public class SettingsActivityViewModel extends AndroidViewModel {

    private final LiveData<List<SocialNetwork>> socialNetworks;
    private SocialNetworkRepository socialNetworkRepository;
    private MutableLiveData<Map<Integer, SocialNetwork>> changesMap;

    private List<SocialNetwork> initialSocialNetworksState;

    public SettingsActivityViewModel(Application application) {
        super(application);
        socialNetworkRepository = new SocialNetworkRepository(application);
        socialNetworks = socialNetworkRepository.getSocialNetworks();
        changesMap = new MutableLiveData<>(new HashMap<>());

    }

    public LiveData<Map<Integer, SocialNetwork>> getChanges(){
        return changesMap;
    }

    public LiveData<List<SocialNetwork>> getSocialNetworks(){
        return socialNetworks;
    }

    public void modifySocialNetwork(SocialNetwork socialNetwork){
        int id = socialNetwork.getId();
        Map<Integer, SocialNetwork> changes = changesMap.getValue();

        if(changes.containsKey(id)){
            changes.remove(id);
        } else{
            SocialNetwork newSocialNetworkChanged = socialNetwork.clone();
            newSocialNetworkChanged.setId(id);
            newSocialNetworkChanged.setChecked(!socialNetwork.isChecked());
            changes.put(id, newSocialNetworkChanged);
        }

        changesMap.setValue(changes);

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

    public void removeAllChanges() {
        this.changesMap.setValue(new HashMap<>());
    }

    public void updateAll() {
        socialNetworkRepository.updateAll(this.changesMap.getValue().values());
    }
}
