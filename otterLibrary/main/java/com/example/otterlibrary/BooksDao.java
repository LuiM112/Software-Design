package com.example.otterlibrary;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BooksDao {
    @Insert
    void addBook(Books account);

    @Query("SELECT COUNT(*) FROM bookBank")
    int count();

    @Query("SELECT * FROM bookBank")
    List<Books> getAll();

    @Query("SELECT * FROM bookBank WHERE genre = :genre")
    List<Books> findBookByGenre(String genre);

    @Query("DELETE FROM bookBank where title = :title")
    void deleteByTitle(String title);

    @Delete
    void delete(Books book);

}
