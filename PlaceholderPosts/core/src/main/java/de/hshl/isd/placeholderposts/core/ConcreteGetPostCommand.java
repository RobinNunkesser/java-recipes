package de.hshl.isd.placeholderposts.core;

import java.util.concurrent.CompletableFuture;

import de.hshl.isd.placeholderposts.core.ports.CrudRepository;
import de.hshl.isd.placeholderposts.core.ports.GetPostCommand;
import de.hshl.isd.placeholderposts.core.ports.Post;
import de.hshl.isd.placeholderposts.core.ports.PostIDDTO;

public class ConcreteGetPostCommand implements GetPostCommand {

    CrudRepository<Long, Post> repository;

    public ConcreteGetPostCommand(
            CrudRepository<Long, Post> repository) {
        this.repository = repository;
    }

    @Override
    public CompletableFuture<String> execute(PostIDDTO inDTO) {
        return repository.retrieve(inDTO.getId()).thenApply(post -> post.getBody());
    }
}