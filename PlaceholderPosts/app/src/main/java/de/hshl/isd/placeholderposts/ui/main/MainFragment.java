package de.hshl.isd.placeholderposts.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.hshl.isd.placeholderposts.R;
import de.hshl.isd.placeholderposts.core.ConcreteGetPostCommand;
import de.hshl.isd.placeholderposts.core.ports.GetPostCommand;
import de.hshl.isd.placeholderposts.infrastructure.adapters.PostRepositoryAdapter;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel

        GetPostCommand service = new ConcreteGetPostCommand(new PostRepositoryAdapter());
        service.execute(new ConcretePostIDDTO(1)).thenApply(result -> Log.d("MainFragment", result));
    }

}