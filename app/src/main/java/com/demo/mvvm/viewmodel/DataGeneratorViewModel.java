package com.demo.mvvm.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class DataGeneratorViewModel extends ViewModel {

    private String TAG = this.getClass().getSimpleName();

    private MutableLiveData<String> mRandomNumber;

    public MutableLiveData<String> getRandomNumber() {
        Log.i(TAG, "GET RANDOM NUMBER");

        if (mRandomNumber == null) {
            mRandomNumber = new MutableLiveData<>();
            createRandomNumber();
        }

        return mRandomNumber;
    }

    public void createRandomNumber() {
        Log.i(TAG, "CREATE RANDOM NUMBER");
        Random mRand = new Random();
        mRandomNumber.setValue("" + (mRand.nextInt(10 - 1) + 1));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "CLEARED");
    }
}