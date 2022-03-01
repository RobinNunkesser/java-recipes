package de.hshl.isd.placeholderposts.core.ports;

import java.util.concurrent.CompletableFuture;

interface Command<InDTOType, OutDTOType> {
    CompletableFuture<OutDTOType> execute(InDTOType inDTO);
}

