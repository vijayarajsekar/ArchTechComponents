package com.demo.mvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.demo.mvvm.R;
import com.demo.mvvm.lifecycleobserver.MainActivityObserver;
import com.demo.mvvm.viewmodel.DataGeneratorViewModel;

public class MainActivity extends AppCompatActivity {

    String TAG = MainActivity.class.getSimpleName();

    private TextView mRandomValue;
    private DataGeneratorViewModel mDataGenerator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add Observer into Activity
        getLifecycle().addObserver(new MainActivityObserver());

        Log.i(TAG, "OWN - ON_CREATE");

        mRandomValue = findViewById(R.id.txt_value);

        mDataGenerator = ViewModelProviders.of(this).get(DataGeneratorViewModel.class);
        LiveData<String> mData = mDataGenerator.getRandomNumber();

        mData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mRandomValue.setText(s);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataGenerator.createRandomNumber();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "OWN - ON_START");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "OWN - ON_PAUSE");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "OWN - ON_RES");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "OWN - ON_STOP");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "OWN - ON_DEST");
    }
}
