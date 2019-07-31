package com.demo.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.mvvm.R;
import com.demo.mvvm.database.Note;
import com.demo.mvvm.ui.NoteRecyclerView;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;

    private List<Note> mNoteList;

    public NoteListAdapter(Context _ctx) {
        this.mInflater = LayoutInflater.from(_ctx);
        this.mContext = _ctx;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = mInflater.inflate(R.layout.note_list_items, parent, false);
        NoteViewHolder mNoteViewHolder = new NoteViewHolder(mView);
        return mNoteViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        if (mNoteList != null) {
            Note mNote = mNoteList.get(position);
            holder.setData(mNote.getNote(), position);
        } else {
            holder.mItemTxt.setText("No Data Avail");
        }
    }

    public void setNote(List<Note> _note) {
        mNoteList = _note;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mNoteList != null ? mNoteList.size() : 0;
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView mItemTxt;
        private int mPositon;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);

            mItemTxt = itemView.findViewById(R.id.txt_item_value);
        }

        public void setData(String mNote, int position) {
            mItemTxt.setText(mNote);
            mPositon = position;
        }
    }
}