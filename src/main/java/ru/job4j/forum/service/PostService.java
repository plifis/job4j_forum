package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.Repository.MemCommentStore;
import ru.job4j.forum.Repository.MemPostStore;
import ru.job4j.forum.Repository.MemUserStore;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.Collection;
import java.util.List;

@Service
public class PostService {
    private MemUserStore storeUsers;
    private MemPostStore storePosts;
    private MemCommentStore storeComments;


    public PostService(MemUserStore storeUsers, MemPostStore storePosts, MemCommentStore storeComments) {
        this.storePosts = storePosts;
        this.storeUsers = storeUsers;
        this.storeComments = storeComments;
    }


    public User findUserByName(String name) {
        return this.storeUsers.findUserByUsername(name);
    }


    public Collection<User> getAllUsers() {
        return storeUsers.getAll();
    }

    public Collection<Post> getAllPosts() {
        return storePosts.getAll();
    }

    public Post findPostById(int id) {
        return this.storePosts.getPostById(id);
    }

    public void savePost(Post post) {
        this.storePosts.save(post);
    }

    public void saveComment(int id, Comment comment) {
        this.storeComments.save(id, comment);
    }

    public List<Comment> getAllCommentsById(int id) {
        return this.storeComments.getAllCommentsById(id);
    }
}