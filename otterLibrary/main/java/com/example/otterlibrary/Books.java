package com.example.otterlibrary;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bookBank")
public class Books {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "Genre")
    private String genre;

    @ColumnInfo(name="Author")
    private String author;

    @ColumnInfo(name="Title")
    private String book;

    public Books(String genre, String author, String book) {
        this.genre = genre;
        this.author = author;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return book;
    }
}