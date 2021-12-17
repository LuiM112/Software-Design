package com.example.otterlibrary;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TransactionBook")
public class TransactionBooks {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name="books")
    private String book;


    public TransactionBooks(String username, String book) {
        this.username = username;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBook() {
        return book;
    }

    public void setType(String book) {
        this.book = book;
    }

    @Override
    public String toString() {
        //String info =

        return username;
    }

}
