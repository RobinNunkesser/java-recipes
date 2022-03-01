package de.hshl.isd.placeholderposts.infrastructure;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class JSONPlaceholderServiceTest {
    JSONPlaceholderService service;

    @Before
    public void setUp() throws Exception {
        service = new JSONPlaceholderService();
    }

    @Test
    public void readAllPosts() {
        try {
            List<PlaceholderPost> posts = service.readAllPosts().get();
            assertEquals(100, posts.size());
        } catch (Exception e) {
            fail(e.getLocalizedMessage());
        }
    }

}
