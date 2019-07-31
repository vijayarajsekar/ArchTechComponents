package com.demo.mvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.demo.mvvm.R;
import com.demo.mvvm.adapter.NoteListAdapter;
import com.demo.mvvm.database.Note;
import com.demo.mvvm.viewmodel.NoteViewModel;

import java.util.List;

public class NoteRecyclerView extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private NoteListAdapter mAdapter;
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_recycler_view);

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);

        mRecyclerView = findViewById(R.id.note_list);
        mAdapter = new NoteListAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        noteViewModel.getAllNote().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                mAdapter.setNote(notes);
            }
        });
    }
}
