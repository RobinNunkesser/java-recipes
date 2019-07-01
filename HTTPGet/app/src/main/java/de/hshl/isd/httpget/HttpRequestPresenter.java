package de.hshl.isd.httpget;

import de.hshl.isd.basiccleanarch.Presenter;

public class HttpRequestPresenter
        implements Presenter<HttpRequestModel, String> {
    @Override
    public String present(HttpRequestModel httpRequestModel) {
        return "Origin: " + httpRequestModel.getOrigin() + ", Url: " +
                httpRequestModel.getUrl();
    }
}

