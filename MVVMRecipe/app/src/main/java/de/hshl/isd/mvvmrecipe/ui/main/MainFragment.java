package de.hshl.isd.mvvmrecipe.ui.main;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import de.hshl.isd.mvvmrecipe.R;

public class MainFragment extends Fragment implements TextWatcher {

    private MainViewModel mViewModel;
    private EditText mForenameEditText;
    private EditText mSurnameEditText;
    private TextView mForenameTextView;
    private TextView mSurnameTextView;
    private TextView mNameTextView;
    private TextView mComputedNameTextView;
    private Button mComputeButton;
    private Button mResetButton;

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
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mForenameEditText = (EditText) requireActivity().findViewById(R.id.forenameEditText);
        mSurnameEditText = (EditText) requireActivity().findViewById(R.id.surnameEditText);
        mForenameTextView = (TextView) requireActivity().findViewById(R.id.forenameTextView);
        mSurnameTextView = (TextView) requireActivity().findViewById(R.id.surnameTextView);
        mNameTextView = (TextView) requireActivity().findViewById(R.id.nameTextView);
        mComputedNameTextView =
                (TextView) requireActivity().findViewById(R.id.computedNameTextView);
        mComputeButton = (Button) requireActivity().findViewById(R.id.computeButton);
        mResetButton = (Button) requireActivity().findViewById(R.id.resetButton);

        // One way bindings for forenameTextView, surnameEditText,
        // surnameTextView, nameTextView, and computedNameTextView
        mViewModel.getForename().observe(getViewLifecycleOwner(), v -> mForenameTextView.setText(v));
        mViewModel.getSurname().observe(getViewLifecycleOwner(), v -> mSurnameTextView.setText(v));
        mViewModel.getMediatorName().observe(getViewLifecycleOwner(), v -> mNameTextView.setText(v));
        mViewModel.getName().observe(getViewLifecycleOwner(), v -> mComputedNameTextView.setText(v));

        // One way to source binding for forenameEditText and surnameEditText
        mForenameEditText.addTextChangedListener(this);
        mSurnameEditText.addTextChangedListener(this);

        mResetButton.setOnClickListener((v) -> {
            mViewModel.setForename("");
            mViewModel.setSurname("");
        });

        mComputeButton.setOnClickListener((v) -> {
            mViewModel.computeName();
        });
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1,
            int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1,
            int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (mForenameEditText.getEditableText().equals(editable)) {
            mViewModel.setForename(editable.toString());
        }
        if (mSurnameEditText.getEditableText().equals(editable)) {
            mViewModel.setSurname(editable.toString());
        }
    }

}