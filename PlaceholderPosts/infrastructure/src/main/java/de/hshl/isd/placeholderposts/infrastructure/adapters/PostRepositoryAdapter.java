package de.hshl.isd.placeholderposts.infrastructure.adapters;

import com.sun.tools.javac.util.List;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

import de.hshl.isd.placeholderposts.core.ports.CrudRepository;
import de.hshl.isd.placeholderposts.core.ports.Post;
import de.hshl.isd.placeholderposts.infrastructure.JSONPlaceholderService;
import de.hshl.isd.placeholderposts.infrastructure.PlaceholderPost;

public class PostRepositoryAdapter implements CrudRepository<Long, Post> {

    JSONPlaceholderService service = new JSONPlaceholderService();

    @Override
    public CompletableFuture<Post> retrieve(Long id) {
        return service.readPost(id).thenApply(mapPlaceholderPost());
    }

    private Function<PlaceholderPost, Post> mapPlaceholderPost() {
        return post -> new PostEntity(post.getId(),
                post.getUserId(), post.getTitle(), post.getBody());
    }

    @Override
    public CompletableFuture<List<Post>> retrieveAll() {
        return service.readAllPosts().thenApply(mapPlaceholderPosts());
    }

    private Function<java.util.List<PlaceholderPost>, List<Post>> mapPlaceholderPosts() {
        return posts -> (List<Post>) posts.stream().map(mapPlaceholderPost())
                .collect(
                        Collectors.toList());
    }
}

