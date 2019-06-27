package de.hshl.isd.bottomnavigation;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity implements
        SecondLevelFragment.OnFragmentInteractionListener {

    private NavController mNavController;
    private BottomNavigationView mNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNavController =
                Navigation.findNavController(this, R.id.nav_host_fragment);
        mNavView = findViewById(R.id.nav_view);
        NavigationUI.setupWithNavController(mNavView, mNavController);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.i("MainActivity", "Received ${value}");
    }
}
