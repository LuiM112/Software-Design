package com.example.otterlibrary;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {TransactionBooks.class}, version = 2, exportSchema = false)
public abstract class TransactionBooksDatabase extends RoomDatabase{

    public abstract TransactionBooksDao info();

    private static TransactionBooksDatabase sInstance;

    public static synchronized TransactionBooksDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    TransactionBooksDatabase.class, "TransactionBooks.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }
}
