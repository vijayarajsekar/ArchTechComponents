package com.demo.mvvm.viewmodel;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.demo.mvvm.database.Note;
import com.demo.mvvm.database.NoteDao;
import com.demo.mvvm.database.NoteDatabse;

public class NoteViewModel extends AndroidViewModel {

    String TAG = NoteViewModel.class.getSimpleName();

    private NoteDao mNoteDao;
    private NoteDatabse mNoteDatabse;

    public NoteViewModel(@NonNull Application application) {
        super(application);

        mNoteDatabse = NoteDatabse.getInstance(application);
        mNoteDao = mNoteDatabse.mNoteDao();
    }

    public void insert(Note _note) {
        new InsertAsync(mNoteDao).execute(_note);
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        Log.i(TAG, "NoteViewModel :: CLEARED");

    }

    private class InsertAsync extends AsyncTask<Note, Void, Void> {

        NoteDao mNoteDao;

        public InsertAsync(NoteDao _dao) {
            this.mNoteDao = _dao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            mNoteDao.insert(notes[0]);

            return null;
        }
    }
}
