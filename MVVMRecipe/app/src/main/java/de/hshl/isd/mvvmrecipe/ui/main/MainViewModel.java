package de.hshl.isd.mvvmrecipe.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    // Two way bindable values
    private final MutableLiveData<String> forename = new MutableLiveData<>();
    private final MutableLiveData<String> surname = new MutableLiveData<>();

    public LiveData<String> getForename() {
        return forename;
    }
    public void setForename(String value) {
        forename.setValue(value);
    }
    public LiveData<String> getSurname() {
        return surname;
    }
    public void setSurname(String value) {
        surname.setValue(value);
    }

    // One way bindable value
    private final MutableLiveData<String> name = new MutableLiveData<>();
    public LiveData<String> getName() {
        return name;
    }

    // Mediated value
    MediatorLiveData<String> mediatorName = new MediatorLiveData<String>();
    public LiveData<String> getMediatorName() {
        return mediatorName;
    }

    public MainViewModel() {
        mediatorName.addSource(forename, (v) -> { mediatorName.setValue(forename.getValue() + " " + surname.getValue()); });
        mediatorName.addSource(surname, (v) -> { mediatorName.setValue(forename.getValue() + " " + surname.getValue()); });
    }

    public void computeName() {
        name.setValue(forename.getValue() + " " + surname.getValue());
    }

}