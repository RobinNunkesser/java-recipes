package de.hshl.isd.basicinteraction.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import de.hshl.isd.basicinteraction.R;

public class MainFragment extends Fragment {

    private Button mButton;
    private EditText mEditTextPersonName;
    private TextView mMessage;

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
        mEditTextPersonName = requireActivity().findViewById(R.id.editTextTextPersonName);
        mButton = requireActivity().findViewById(R.id.button);
        mMessage = requireActivity().findViewById(R.id.message);

        mButton.setOnClickListener((v) -> mMessage.setText(
                mEditTextPersonName.getText().toString().toUpperCase()));



    }

}