package com.jackie.flash.repositories;

import androidx.lifecycle.MutableLiveData;

import com.jackie.flash.models.SocialNetwork;

import java.util.ArrayList;
import java.util.List;

import static com.jackie.flash.utils.Constants.SOCIAL_NETWORK_LIST;

public class SocialNetworkRepository {

    private static SocialNetworkRepository instance;
    private List<SocialNetwork> dataSet ;

    private SocialNetworkRepository(){
        dataSet = new ArrayList<>();
    }

    public static SocialNetworkRepository getInstance(){
        if(instance == null){
            instance = new SocialNetworkRepository();
        }
        return instance;

    }


    //TODO: Make Api to fetch real data
    public MutableLiveData<List<SocialNetwork>> getSocialNetworks(){
        setSocialNetworks();

        MutableLiveData<List<SocialNetwork>> data = new MutableLiveData<>();

        data.setValue(dataSet);

        return data;
    }

    private void setSocialNetworks(){
        dataSet = SOCIAL_NETWORK_LIST;
    }
}
