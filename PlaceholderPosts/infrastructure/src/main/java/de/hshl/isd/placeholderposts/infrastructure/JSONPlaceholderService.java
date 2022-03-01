package de.hshl.isd.placeholderposts.infrastructure;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class JSONPlaceholderService implements JSONPlaceholderAPI {

    JSONPlaceholderAPI service;

    public JSONPlaceholderService() {
        Retrofit retrofit =
                new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        service = retrofit.create(JSONPlaceholderAPI.class);
    }

    @Override
    public CompletableFuture<PlaceholderPost> readPost(Long id) {
        return service.readPost(id);
    }

    @Override
    public CompletableFuture<List<PlaceholderPost>> readAllPosts() {
        return service.readAllPosts();
    }

    @Override
    public CompletableFuture<PlaceholderPost> createPost(PlaceholderPost post) {
        return service.createPost(post);
    }

    @Override
    public CompletableFuture<PlaceholderPost> updatePost(Long id, PlaceholderPost post) {
        return service.updatePost(id, post);
    }

    @Override
    public CompletableFuture<Void> deletePost(Long id) {
        return service.deletePost(id);
    }
}
