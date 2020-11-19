package com.jackie.flash.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.jackie.flash.models.SocialNetwork;
import com.jackie.flash.repositories.SocialNetworkRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jackie.flash.utils.Constants.SOCIAL_NETWORK_LIST;

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
            /*LiveData<List<SocialNetwork>> prue = mSocialNetworks;

            ArrayList<SocialNetwork> prueba = new ArrayList<SocialNetwork>(mSocialNetworks.getValue());*/

            initialSocialNetworksState = SOCIAL_NETWORK_LIST;

        }
    }


    public void changeSocialNetworkChecked(int index){



        List<SocialNetwork> updatedSocialNetworks = mSocialNetworks.getValue();

        SocialNetwork foundSocialNetwork = updatedSocialNetworks.get(index);
        foundSocialNetwork.setChecked(! foundSocialNetwork.isChecked());


//        updatedSocialNetworks.get(index).setChecked(!updatedSocialNetworks.get(index).isChecked());


        mSocialNetworks.setValue(updatedSocialNetworks);



    }

    public LiveData<List<SocialNetwork>> getSocialNetworks(){
        return mSocialNetworks;
    }

    public boolean validateForDataUpdates(List<SocialNetwork> socialNetworks) {
//        System.out.println(socialNetworks.get(0) + "==" + this.initialSocialNetworksState.get(0) + "LIST"+ SOCIAL_NETWORK_LIST );
        return !socialNetworks.equals(initialSocialNetworksState);
    }
}
