package de.hshl.isd.placeholderposts.ui.main;

import de.hshl.isd.placeholderposts.core.ports.PostIDDTO;

class ConcretePostIDDTO implements PostIDDTO {

    private long id;

    public ConcretePostIDDTO(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }
}
