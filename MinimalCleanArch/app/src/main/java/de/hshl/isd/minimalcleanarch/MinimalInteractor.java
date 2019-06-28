package de.hshl.isd.minimalcleanarch;

import org.jetbrains.annotations.NotNull;

import de.hshl.isd.basiccleanarch.Displayer;
import de.hshl.isd.basiccleanarch.Presenter;
import de.hshl.isd.basiccleanarch.Response;
import de.hshl.isd.basiccleanarch.UseCase;

public class MinimalInteractor implements UseCase<Void, Integer, String> {

    private Presenter<Integer, String> mPresenter;

    public MinimalInteractor(Presenter<Integer, String> presenter) {
        mPresenter = presenter;
    }

    @NotNull
    @Override
    public Presenter<Integer, String> getPresenter() {
        return mPresenter;
    }

    @Override
    public void execute(Void aVoid, @NotNull Displayer displayer) {
        Integer entity = 42;
        String viewModel = mPresenter.present(entity);
        displayer.display(new Response.Success<String>(viewModel));
    }
}