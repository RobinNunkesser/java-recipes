package de.hshl.isd.list;

import java.util.Arrays;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModel extends ViewModel {

    private MutableLiveData<List<String>> data =
            new MutableLiveData<List<String>>();

    public ItemViewModel() {
        this.data.setValue(
                Arrays.asList("Teddy bear", "Banana", "Sponge", "Laptop"));
    }

    public LiveData<List<String>> getData() {
        return data;
    }

}
