package de.hshl.isd.placeholderposts.infrastructure;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JSONPlaceholderAPI {
    @GET("posts/{id}")
    Call<PlaceholderPost> readPost(@Path("id") Long id);

    @GET("posts")
    Call<List<PlaceholderPost>> readAllPosts();

    @POST("posts")
    Call<PlaceholderPost> createPost(@Body PlaceholderPost post);

    @PUT("posts/{id}")
    Call<PlaceholderPost> updatePost(@Path("id") Long id, @Body PlaceholderPost post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") Long id);
}