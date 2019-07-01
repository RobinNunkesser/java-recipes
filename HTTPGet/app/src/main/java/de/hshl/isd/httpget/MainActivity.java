package de.hshl.isd.httpget;

import android.os.Bundle;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import androidx.appcompat.app.AppCompatActivity;
import de.hshl.isd.basiccleanarch.Displayer;
import de.hshl.isd.basiccleanarch.Response;
import de.hshl.isd.basiccleanarch.UseCase;

public class MainActivity extends AppCompatActivity implements Displayer {

    public static final String TAG = "MainActivity";
    private UseCase<Void, HttpRequestModel, String> interactor =
            new GetHttpRequestInteractor(new HttpRequestPresenter(),
                    new HttpBinGateway());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        interactor.execute(null, this);
    }

    @Override
    public void display(@NotNull Response response) {
        if (response instanceof Response.Success) {
            Log.i(TAG, (String) ((Response.Success) response).getValue());
        } else if (response instanceof Response.Failure) {
            Log.e(TAG, ((Response.Failure) response).getError()
                    .getLocalizedMessage());
        }

    }
}