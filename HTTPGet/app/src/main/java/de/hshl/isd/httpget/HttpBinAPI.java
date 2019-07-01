package de.hshl.isd.httpget;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HttpBinAPI {
    @GET("get")
    Call<HttpRequestModel> getExample();
}

