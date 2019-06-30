package de.hshl.isd.asyncrecipe;

import android.os.AsyncTask;

public abstract class AsyncHookedTask<Params, Progress, Result>
        extends AsyncTask<Params, Progress, Result> {

    protected OnTaskCompleted<Result> onComplete;

    public AsyncHookedTask(OnTaskCompleted<Result> onComplete) {
        super();
        this.onComplete = onComplete;
    }

    @Override
    protected void onPostExecute(Result result) {
        super.onPostExecute(result);
        onComplete.onTaskCompleted(result);
    }

    interface OnTaskCompleted<Result> {
        void onTaskCompleted(Result result);

        void onError(Exception e);
    }

}
