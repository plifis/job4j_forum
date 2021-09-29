package ru.job4j.forum.Repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

//@Repository
public class MemPostStore {
    private final Map<Integer, Post> mem = new HashMap<>();
    private static final AtomicInteger COUNT = new AtomicInteger(0);

    public MemPostStore() {
        mem.put(COUNT.incrementAndGet(), Post.of(COUNT.get(), "Продаю машину ладу 01."));
        }

    public void save(Post post) {
        post.setId(COUNT.incrementAndGet());
        this.mem.put(post.getId(), post);
    }

    public Collection<Post> getAll() {
        return mem.values();
    }

    public Post getPostById(int id) {
        return this.mem.get(id);
    }
}
