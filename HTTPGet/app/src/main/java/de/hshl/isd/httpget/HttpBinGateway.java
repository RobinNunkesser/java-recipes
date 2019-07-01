package de.hshl.isd.httpget;

import de.hshl.isd.basiccleanarch.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpBinGateway {

    public Response fetchData() {
        Retrofit.Builder builder = new Retrofit.Builder();
        HttpBinAPI service =
                builder.baseUrl("https://httpbin.org/").addConverterFactory(
                        GsonConverterFactory.create()).build()
                        .create(HttpBinAPI.class);
        try {
            retrofit2.Response response = service.getExample().execute();
            return new Response.Success<>(
                    (HttpRequestModel) response.body());
        } catch (Throwable t) {
            return new Response.Failure(t);
        }
    }
}