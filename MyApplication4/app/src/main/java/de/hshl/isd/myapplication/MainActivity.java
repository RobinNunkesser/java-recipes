package de.hshl.isd.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.navigation.Navigation;
import de.hshl.isd.myapplication.ui.main.MainFragment;
import de.hshl.isd.myapplication.ui.second.SecondFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_nextpage:
                Bundle bundle = new Bundle();
                bundle.putString(SecondFragment.ARG_PARAM1, "Hello");
                bundle.putString(SecondFragment.ARG_PARAM2, "World");
                Navigation.findNavController(this, R.id.nav_host_fragment_container)
                        .navigate(R.id.action_mainFragment_to_secondFragment, bundle);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}