package com.demo.mvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.demo.mvvm.R;
import com.demo.mvvm.database.Note;
import com.demo.mvvm.lifecycleobserver.MainActivityObserver;
import com.demo.mvvm.viewmodel.NoteViewModel;

import java.util.UUID;

public class RoomDbActivity extends AppCompatActivity {

    String TAG = RoomDbActivity.class.getSimpleName();
    private NoteViewModel mNoteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_db);

        getLifecycle().addObserver(new MainActivityObserver());

        mNoteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Note mNote = new Note(UUID.randomUUID().toString(), "Hello Jasmine");
                mNoteViewModel.insert(mNote);

                Log.i(TAG, " ~ Insert Completed ~ ");

            }
        });
    }
}