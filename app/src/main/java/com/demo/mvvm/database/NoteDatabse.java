package com.demo.mvvm.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Note.class, version = 1)
public abstract class NoteDatabse extends RoomDatabase {

    public abstract NoteDao mNoteDao();

    private static volatile NoteDatabse mDatabaseInstance;

    public static NoteDatabse getInstance(Context _ctx) {

        if (mDatabaseInstance == null) {
            synchronized (NoteDatabse.class) {
                if (mDatabaseInstance == null) {
                    mDatabaseInstance = Room.databaseBuilder(_ctx.getApplicationContext(), NoteDatabse.class, "note_database").build();
                }
            }
        }

        return mDatabaseInstance;
    }
}