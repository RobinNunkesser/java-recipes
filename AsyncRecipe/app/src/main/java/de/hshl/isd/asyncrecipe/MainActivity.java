package de.hshl.isd.asyncrecipe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            URL url1 = new URL("http://www.hshl.de/");
            URL url2 = new URL("http://www.hshl.de/hochschule-hamm-lippstadt/");
            new DownloadFilesTask(
                    new AsyncHookedTask.OnTaskCompleted<Integer>() {
                        @Override
                        public void onTaskCompleted(Integer result) {
                            Toast.makeText(getApplicationContext(),
                                    "Downloaded " + result + " files",
                                    Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onError(Exception e) {
                            Toast.makeText(getApplicationContext(),
                                    e.getLocalizedMessage(), Toast.LENGTH_SHORT)
                                    .show();

                        }
                    }
            ).execute(url1, url2);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
