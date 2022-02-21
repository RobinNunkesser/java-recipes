package de.hshl.isd.helloworld.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private final MutableLiveData<String> data = new MutableLiveData<>();

    public MainViewModel() {
        this.data.setValue("Hello ViewModel world");
    }

    public LiveData<String> getData() {
        return data;
    }
}
