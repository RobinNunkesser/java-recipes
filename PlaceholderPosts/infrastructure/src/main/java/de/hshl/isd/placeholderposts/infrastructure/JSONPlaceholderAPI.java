package de.hshl.isd.placeholderposts.infrastructure;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface JSONPlaceholderAPI {
    @GET("posts/{id}")
    CompletableFuture<PlaceholderPost> readPost(@Path("id") Long id);

    @GET("posts")
    CompletableFuture<List<PlaceholderPost>> readAllPosts();

    @POST("posts")
    CompletableFuture<PlaceholderPost> createPost(@Body PlaceholderPost post);

    @PUT("posts/{id}")
    CompletableFuture<PlaceholderPost> updatePost(@Path("id") Long id, @Body PlaceholderPost post);

    @DELETE("posts/{id}")
    CompletableFuture<Void> deletePost(@Path("id") Long id);
}