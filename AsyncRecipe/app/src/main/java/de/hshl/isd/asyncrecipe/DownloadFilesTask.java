package de.hshl.isd.asyncrecipe;

import android.util.Log;

import java.net.URL;

class DownloadFilesTask
        extends AsyncHookedTask<URL, Integer, Integer> {
    public DownloadFilesTask(OnTaskCompleted<Integer> onComplete) {
        super(onComplete);
    }

    protected Integer doInBackground(URL... urls) {
        int count = urls.length;
        for (int i = 0; i < count; i++) {
            publishProgress((int) ((i / (float) count) * 100));
            if (isCancelled())
                break;
        }
        return count;
    }

    protected void onProgressUpdate(Integer... progress) {
        Log.i("DownloadFilesTask", progress[0].toString());
    }
}
