package de.hshl.isd.minimalcleanarch;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import androidx.appcompat.app.AppCompatActivity;
import de.hshl.isd.basiccleanarch.Displayer;
import de.hshl.isd.basiccleanarch.Response;
import de.hshl.isd.basiccleanarch.UseCase;

public class MainActivity extends AppCompatActivity implements Displayer {

    private UseCase<Void, Integer, String> mInteractor =
            new MinimalInteractor(new MinimalPresenter());
    private TextView mLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLabel = findViewById(R.id.label);

        findViewById(R.id.button).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mInteractor.execute(null, MainActivity.this);
                    }
                });
    }

    @Override
    public void display(@NotNull Response response) {
        if (response instanceof Response.Success) {
            mLabel.setText((String) ((Response.Success) response).getValue());
        } else if (response instanceof Response.Failure) {
            Log.e("MainActivity", ((Response.Failure) response).getError()
                    .getLocalizedMessage());
        }
    }
}