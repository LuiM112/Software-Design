package com.example.otterlibrary;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TransactionAccountDao {
    @Insert
    void addAccount(TransactionAccount account);

    @Query("SELECT COUNT(*) FROM TransactionAcc")
    int count();

    @Query("SELECT * FROM TransactionAcc")
    List<TransactionAccount> getAll();

    @Delete
    void delete(TransactionAccount account);

}
