package de.hshl.isd.placeholderposts.infrastructure;

public class PlaceholderPost {
    private long userId;
    private long id;
    private String title;
    private String body;

    public PlaceholderPost(long id, long userId, String title,
            String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
