package com.example.otterlibrary;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TransactionAccount.class}, version = 2, exportSchema = false)
public abstract class TransactionAccountDatabase extends RoomDatabase{

    public abstract TransactionAccountDao info();

    private static TransactionAccountDatabase sInstance;

    public static synchronized TransactionAccountDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    TransactionAccountDatabase.class, "TransactionAccount.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }
}
