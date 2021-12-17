package com.example.otterlibrary;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Books.class}, version = 2, exportSchema = false)
public abstract class BooksDatabase extends RoomDatabase {

    public abstract BooksDao info();

    private static BooksDatabase sInstance;

    public static synchronized BooksDatabase getInstance(Context context) {
        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                    BooksDatabase.class, "books.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;
    }

    public void populateInitialData() {
        if (info().count() == 0) {
            runInTransaction(() -> {
                info().addBook(
                        new Books("Memoir","Frank McCourt", "Angela's Ashes"
                        ));
                info().addBook(
                        new Books("Fiction","Mary Shelley", "Frankenstein"
                        ));
            });
        }
    }
}
