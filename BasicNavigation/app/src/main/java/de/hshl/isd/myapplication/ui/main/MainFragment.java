package de.hshl.isd.myapplication.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.navigation.Navigation;
import de.hshl.isd.myapplication.R;
import de.hshl.isd.myapplication.ui.second.SecondFragment;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private Button mButton;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu,
            @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
        mButton = requireActivity().findViewById(R.id.button);

        mButton.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString(SecondFragment.ARG_PARAM1, "Hello");
            bundle.putString(SecondFragment.ARG_PARAM2, "World");
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_container)
                    .navigate(R.id.action_mainFragment_to_secondFragment, bundle);
        });
    }

}