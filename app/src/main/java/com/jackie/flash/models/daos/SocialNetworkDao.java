package com.jackie.flash.models.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.jackie.flash.models.entities.SocialNetwork;

import java.util.List;

@Dao
public interface SocialNetworkDao {
    @Insert
    void insert(SocialNetwork socialNetwork);

    @Update
    void update(SocialNetwork socialNetwork);

    @Delete
    void delete(SocialNetwork socialNetwork);


    @Query("SELECT name, icon, checked FROM "+ SocialNetwork.TABLE_NAME)
    LiveData<List<SocialNetwork>> getAllSocialNetworks();


//    @Update("UPDATE "+ SocialNetwork.TABLE_NAME + " SET checked=")
//    void updateChecked(SocialNetwork socialNetwork);
}
