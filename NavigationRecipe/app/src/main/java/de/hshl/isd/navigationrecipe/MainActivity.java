package de.hshl.isd.navigationrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements
        MainFragment.OnFragmentInteractionListener {

    public static final String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = MainFragment.newInstance("value1", "value2");
        final FragmentTransaction transaction =
                fragmentManager.beginTransaction();
        transaction.add(R.id.content, fragment).commit();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
            Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        Log.i(LOG_TAG,
                "Received: " + data.getStringExtra(SecondActivity.ARG_RETURN1));
    }

    @Override
    public void onFragmentInteraction(String data) {
        Log.i(LOG_TAG, "Received from fragment: " + data);

    }

    public void onStartActivity(View view) {
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(i);
    }

    public void onStartActivityForResult(View view) {
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        i.putExtra(SecondActivity.ARG_PARAM1, "value1");
        i.putExtra(SecondActivity.ARG_PARAM2, "value2");
        startActivityForResult(i, 0);
    }

}
