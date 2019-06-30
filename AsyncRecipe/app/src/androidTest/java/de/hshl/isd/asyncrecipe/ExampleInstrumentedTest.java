package de.hshl.isd.asyncrecipe;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void testDownload() throws ExecutionException, InterruptedException,
            MalformedURLException {
        final CompletableFuture<Integer> future = new CompletableFuture<>();

        URL url1 = new URL("http://www.hshl.de/");
        URL url2 = new URL("http://www.hshl.de/test/");

        new DownloadFilesTask(
                new AsyncHookedTask.OnTaskCompleted<Integer>() {
                    @Override
                    public void onTaskCompleted(Integer result) {
                        assertEquals(2, result.intValue());
                        future.complete(1);
                    }

                    @Override
                    public void onError(Exception e) {
                        future.complete(-1);
                    }
                }
        ).execute(url1, url2);

        assertEquals(1, (int) future.get());

    }
}
