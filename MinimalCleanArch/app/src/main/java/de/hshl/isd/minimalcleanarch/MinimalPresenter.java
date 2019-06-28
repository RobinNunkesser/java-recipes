package de.hshl.isd.minimalcleanarch;

import de.hshl.isd.basiccleanarch.Presenter;

public class MinimalPresenter implements Presenter<Integer, String> {
    @Override
    public String present(Integer integer) {
        return integer.toString();
    }
}