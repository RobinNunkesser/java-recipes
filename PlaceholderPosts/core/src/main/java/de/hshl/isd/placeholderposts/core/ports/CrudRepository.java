package de.hshl.isd.placeholderposts.core.ports;

import com.sun.tools.javac.util.List;

import java.util.concurrent.CompletableFuture;

public interface CrudRepository<IdType, EntityType> {
    CompletableFuture<EntityType> retrieve(IdType id);
    CompletableFuture<List<EntityType>> retrieveAll();
}
