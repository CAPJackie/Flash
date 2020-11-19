package com.jackie.flash.models;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.jackie.flash.models.daos.SocialNetworkDao;
import com.jackie.flash.models.entities.SocialNetwork;

@Database(entities = SocialNetwork.class, version = 1)
public abstract class FlashDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "flash_database";
    private static FlashDatabase instance;

    public abstract SocialNetworkDao socialNetworkDao();

    public static synchronized FlashDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), FlashDatabase.class, FlashDatabase.DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
