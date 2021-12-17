package com.example.otterlibrary;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TransactionBooksDao {
    @Insert
    void addTransaction(TransactionBooks account);

    @Query("SELECT COUNT(*) FROM TransactionBook")
    int count();

    @Query("SELECT * FROM TransactionBook")
    List<TransactionBooks> getAll();

    @Delete
    void delete(TransactionBooks books);

}
