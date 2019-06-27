package de.hshl.isd.navigationrecipe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    public static final String LOG_TAG = "SecondActivity";

    // the activity  parameters
    public static final String ARG_PARAM1 = "param1";
    public static final String ARG_PARAM2 = "param2";

    public static final String ARG_RETURN1 = "return1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(LOG_TAG,
                "Received: " + getIntent().getStringExtra(ARG_PARAM1) + ", " +
                        getIntent().getStringExtra(ARG_PARAM2));

        setContentView(R.layout.activity_second);
    }

    public void onReturnResult(View view) {
        Intent data = new Intent();
        data.putExtra(ARG_RETURN1, "ReturnValue");
        setResult(RESULT_OK, data);
        finish();
    }

}
