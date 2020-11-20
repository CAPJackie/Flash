package com.jackie.flash.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jackie.flash.models.FlashDatabase;
import com.jackie.flash.models.daos.SocialNetworkDao;
import com.jackie.flash.models.entities.SocialNetwork;

import java.util.ArrayList;
import java.util.List;

import static com.jackie.flash.utils.Constants.SOCIAL_NETWORK_LIST;

public class SocialNetworkRepository {


    private LiveData<List<SocialNetwork>> socialNetworks;
    private SocialNetworkDao socialNetworkDao;

    public SocialNetworkRepository(Application application){

        FlashDatabase flashDatabase = FlashDatabase.getInstance(application);
        this.socialNetworkDao = flashDatabase.socialNetworkDao();
        this.socialNetworks = socialNetworkDao.getAllSocialNetworks();
    }


    public LiveData<List<SocialNetwork>> getSocialNetworks(){
        return socialNetworks;
    }

    public void updateSocialNetwork(final SocialNetwork socialNetwork){
        FlashDatabase.databaseWriteExecutor.execute(()->{
            socialNetworkDao.update(socialNetwork);
        });
    }

}
