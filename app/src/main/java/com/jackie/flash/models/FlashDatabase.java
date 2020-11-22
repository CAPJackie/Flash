package com.jackie.flash.models;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.jackie.flash.R;
import com.jackie.flash.models.daos.SocialNetworkDao;
import com.jackie.flash.models.entities.SocialNetwork;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = SocialNetwork.class, version = 1, exportSchema = false)
public abstract class FlashDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "flash_database";
    private static FlashDatabase instance;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static RoomDatabase.Callback sRoomDataBaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(()->{
                SocialNetworkDao socialNetworkDao = instance.socialNetworkDao();
                socialNetworkDao.deleteAll();



                socialNetworkDao.insertAll(
                        new SocialNetwork("Facebook", R.drawable.facebook_logo),
                        new SocialNetwork("Instagram", R.drawable.instagram_logo),
                        new SocialNetwork("Twitter", R.drawable.twitter_logo),
                        new SocialNetwork("Linkedin", R.drawable.linkedin_logo));

                ;

            });
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };


    public abstract SocialNetworkDao socialNetworkDao();

    public static synchronized FlashDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), FlashDatabase.class, FlashDatabase.DATABASE_NAME)
                    .addCallback(sRoomDataBaseCallback)
                    .build();
        }
        return instance;
    }
}
