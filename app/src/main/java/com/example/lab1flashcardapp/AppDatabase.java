package com.example.lab1flashcardapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {com.example.lab1flashcardapp.Flashcard.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract com.example.lab1flashcardapp.FlashcardDao flashcardDao();
}
