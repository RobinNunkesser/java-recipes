package de.hshl.isd.httpget;

import android.annotation.SuppressLint;

import org.jetbrains.annotations.NotNull;

import de.hshl.isd.basiccleanarch.Displayer;
import de.hshl.isd.basiccleanarch.Presenter;
import de.hshl.isd.basiccleanarch.Response;
import de.hshl.isd.basiccleanarch.UseCase;
import de.hshl.isd.httpget.common.AsyncHookedTask;

public class GetHttpRequestInteractor
        implements UseCase<Void, HttpRequestModel, String> {

    private Presenter<HttpRequestModel, String> mPresenter;
    private HttpBinGateway mGateway;

    public GetHttpRequestInteractor(
            Presenter<HttpRequestModel, String> presenter,
            HttpBinGateway gateway) {
        mPresenter = presenter;
        mGateway = gateway;
    }

    @NotNull
    @Override
    public Presenter<HttpRequestModel, String> getPresenter() {
        return mPresenter;
    }

    @Override
    public void execute(Void aVoid, @NotNull final Displayer displayer) {
        @SuppressLint("StaticFieldLeak")
        AsyncHookedTask<Object, Object, Response> task =
                new AsyncHookedTask<Object, Object, Response>(
                        new AsyncHookedTask.OnTaskCompleted<Response>() {
                            @Override
                            public void onTaskCompleted(Response response) {
                                if (response instanceof Response.Success) {
                                    HttpRequestModel entity =
                                            (HttpRequestModel) ((Response.Success) response)
                                                    .getValue();
                                    String viewModel =
                                            mPresenter.present(entity);
                                    displayer.display(
                                            new Response.Success<>(viewModel));
                                } else if (response instanceof Response.Failure) {
                                    displayer.display(new Response.Failure(
                                            ((Response.Failure) response)
                                                    .getError()));
                                }
                            }

                            @Override
                            public void onError(Throwable t) {
                                displayer.display(new Response.Failure(t));
                            }
                        }) {
                    @Override
                    protected Response doInBackground(Object... objects) {
                        return mGateway.fetchData();
                    }
                };
        task.execute();
    }
}

