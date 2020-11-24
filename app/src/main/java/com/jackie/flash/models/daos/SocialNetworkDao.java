package com.jackie.flash.models.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jackie.flash.models.entities.SocialNetwork;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Dao
public interface SocialNetworkDao {

    @Update
    void update(SocialNetwork socialNetwork);

    @Update
    void updateAll(Collection<SocialNetwork> socialNetworks);

    @Query("SELECT id, name, icon, checked FROM "+ SocialNetwork.TABLE_NAME)
    LiveData<List<SocialNetwork>> getAllSocialNetworks();

    @Query("DELETE FROM "+ SocialNetwork.TABLE_NAME)
    void deleteAll();

    @Insert
    void insertAll(SocialNetwork... socialNetworks);

}
