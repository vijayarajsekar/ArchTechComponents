package com.demo.mvvm.viewmodel;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.demo.mvvm.database.Note;
import com.demo.mvvm.database.NoteDao;
import com.demo.mvvm.database.NoteDatabse;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    String TAG = NoteViewModel.class.getSimpleName();

    private NoteDao mNoteDao;
    private NoteDatabse mNoteDatabse;

    private LiveData<List<Note>> mAllNote;

    public NoteViewModel(@NonNull Application application) {
        super(application);

        mNoteDatabse = NoteDatabse.getInstance(application);
        mNoteDao = mNoteDatabse.mNoteDao();
        mAllNote = mNoteDao.getAllNote();
    }

    public void insert(Note _note) {
        new InsertAsync(mNoteDao).execute(_note);
    }

    public LiveData<List<Note>> getAllNote() {
        return mAllNote;
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
