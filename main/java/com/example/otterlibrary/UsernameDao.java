package com.example.otterlibrary;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UsernameDao {
    @Insert
    void addAccount(Username account);

    @Query("SELECT COUNT(*) FROM UsersBank")
    int count();

    @Query("SELECT * FROM UsersBank")
    List<Username> getAll();

    @Delete
    void delete(Username username);

}
