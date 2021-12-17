package com.example.otterlibrary;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Username.class}, version = 2, exportSchema = false)
public abstract class UsernameDatabase extends RoomDatabase {

    public abstract UsernameDao info();

    private static UsernameDatabase sInstance;

    public static synchronized UsernameDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    UsernameDatabase.class, "username.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }

    public void populateInitialData() {
        if (info().count() == 0) {
            runInTransaction(() -> {
                info().addAccount(
                        new Username("shirleybee","carmel2chicago"
                                ));
                info().addAccount(
                        new Username("!admin2","!admin2"
                        ));
            });
        }
    }
}
