package de.hshl.isd.placeholderposts.infrastructure;

import java.util.List;

import retrofit2.Call;
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
    public Call<PlaceholderPost> readPost(Long id) {
        return service.readPost(id);
    }

    @Override
    public Call<List<PlaceholderPost>> readAllPosts() {
        return service.readAllPosts();
    }

    @Override
    public Call<PlaceholderPost> createPost(PlaceholderPost post) {
        return service.createPost(post);
    }

    @Override
    public Call<PlaceholderPost> updatePost(Long id, PlaceholderPost post) {
        return service.updatePost(id, post);
    }

    @Override
    public Call<Void> deletePost(Long id) {
        return service.deletePost(id);
    }
}
