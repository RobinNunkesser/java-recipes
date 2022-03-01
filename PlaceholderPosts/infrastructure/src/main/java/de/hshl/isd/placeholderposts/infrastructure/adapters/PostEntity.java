package de.hshl.isd.placeholderposts.infrastructure.adapters;

import de.hshl.isd.placeholderposts.core.ports.Post;

class PostEntity implements Post {
    private long userId;
    private long id;
    private String title;
    private String body;

    public PostEntity(long id, long userId, String title,
            String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    @Override
    public long getUserId() {
        return userId;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getBody() {
        return body;
    }
}
