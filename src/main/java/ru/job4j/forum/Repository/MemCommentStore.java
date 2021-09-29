package ru.job4j.forum.Repository;

import ru.job4j.forum.model.Comment;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MemCommentStore {
    private final HashMap<Integer, List<Comment>> mem = new HashMap<>();
    private static final AtomicInteger COUNT = new AtomicInteger(0);

    public void save(int id, Comment comment) {
        if (mem.get(id) == null) {
            mem.put(id, new LinkedList<>());
        }
        mem.get(id).add(comment);
    }

    public List<Comment> getAllCommentsById(int id) {
        return this.mem.get(id);
    }
}
