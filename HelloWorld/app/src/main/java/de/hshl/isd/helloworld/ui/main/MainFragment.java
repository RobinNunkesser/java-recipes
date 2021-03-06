package de.hshl.isd.helloworld.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hshl.isd.helloworld.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private TextView mMessageTextView;

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
    public void onViewCreated(@NonNull View view,
            @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMessageTextView = getActivity().findViewById(R.id.message);
        mViewModel = (new ViewModelProvider(this)).get(MainViewModel.class);
        mViewModel.getData().observe(getViewLifecycleOwner(),
                s -> mMessageTextView.setText(s));
    }

}