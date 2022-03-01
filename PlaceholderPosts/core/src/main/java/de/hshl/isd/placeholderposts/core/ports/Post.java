package de.hshl.isd.placeholderposts.core.ports;

public interface Post {
    long getUserId();
    long getId();
    String getTitle();
    String getBody();
}
