package de.hshl.isd.bottomnavigation;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private Button mNavButton;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mNavButton = (Button) requireActivity().findViewById(R.id.navButton);
        mNavButton.setOnClickListener(
                v -> {
                    Bundle bundle = new Bundle();
                    bundle.putString(SecondLevelFragment.ARG_PARAM1,
                            "value1");
                    bundle.putString(SecondLevelFragment.ARG_PARAM2,
                            "value2");
                    Navigation.findNavController(requireActivity(),
                            R.id.nav_host_fragment).navigate(
                            R.id.action_homeFragment_to_secondLevelFragment,
                            bundle);
                });
    }

}