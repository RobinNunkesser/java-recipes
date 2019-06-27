package de.hshl.isd.helloworld;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> data = new MutableLiveData<String>();

    public MainViewModel() {
        this.data.setValue("Hello world");
    }

    public LiveData<String> getData() {
        return data;
    }
}
