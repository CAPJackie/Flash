package com.jackie.flash.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jackie.flash.models.SocialNetwork;
import com.jackie.flash.repositories.SocialNetworkRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SettingsActivityViewModel extends ViewModel {

    private MutableLiveData<List<SocialNetwork>> mSocialNetworks;
    private SocialNetworkRepository mSocialNetworkRepository;

    private List<SocialNetwork> initialSocialNetworksState;


    public void init(){
        System.out.println("Init called");
        if(mSocialNetworks != null){
            return;
        } else{
            mSocialNetworkRepository = SocialNetworkRepository.getInstance();
            mSocialNetworks = mSocialNetworkRepository.getSocialNetworks();

//            mSocialNetworks.getValue().


            //TODO Pass Initial immutable data to state
            LiveData<List<SocialNetwork>> prue = mSocialNetworks;

            ArrayList<SocialNetwork> prueba = new ArrayList<SocialNetwork>(mSocialNetworks.getValue());

            initialSocialNetworksState =  prue.getValue();

        }
    }


    public void changeSocialNetworkChecked(int index){



        List<SocialNetwork> updatedSocialNetworks = mSocialNetworks.getValue();


//        System.out.println("Item seleccionado " + index);
        SocialNetwork foundSocialNetwork = updatedSocialNetworks.get(index);
//        System.out.println(foundSocialNetwork+ " Found...");
        foundSocialNetwork.setChecked(! foundSocialNetwork.isChecked());


//        updatedSocialNetworks.get(index).setChecked(!updatedSocialNetworks.get(index).isChecked());


        mSocialNetworks.setValue(updatedSocialNetworks);



    }

    public LiveData<List<SocialNetwork>> getSocialNetworks(){
        return mSocialNetworks;
    }

    public boolean validateForDataUpdates(List<SocialNetwork> socialNetworks) {
        System.out.println(socialNetworks.get(0) + "==" + this.initialSocialNetworksState.get(0) );
        return !socialNetworks.equals(this.initialSocialNetworksState);
    }
}
