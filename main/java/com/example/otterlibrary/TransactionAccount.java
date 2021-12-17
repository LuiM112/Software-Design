package com.example.otterlibrary;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TransactionAcc")
public class TransactionAccount {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Transaction Type")
    private String type;

    @ColumnInfo(name="Username")
    private String username;


    public TransactionAccount(String type, String username) {
        this.type = type;
        this.username = username;
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

    public String getType() {
        return type;
    }

    public void setType(String password) {
        this.type = password;
    }

    @Override
    public String toString() {
        //String info =

        return username;
    }

}
