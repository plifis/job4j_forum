package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.Repository.*;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository storePosts;
    private final CommentRepository storeComments;
    private final UserRepository storeUsers;


    public PostService(UserRepository storeUsers, PostRepository storePosts, CommentRepository storeComments) {
        this.storePosts = storePosts;
        this.storeUsers = storeUsers;
        this.storeComments = storeComments;
    }


    public User findUserByName(String name) {
        return this.storeUsers.findUserByName(name);
    }

    public Post findPostById(int id) {
        return this.storePosts.findById(id).get();
    }

    public Post savePost(Post post) {
        return this.storePosts.save(post);
    }

    public Comment saveComment(Comment comment) {
        return this.storeComments.save(comment);
    }

    public User saveUser(User user) {
        return this.storeUsers.save(user);
    }

    public List<User> getAllUsers() {
        List<User> rsl = new ArrayList<>();
        this.storeUsers.findAll().forEach(rsl::add);
        return rsl;
    }

    public List<Post> getAllPosts() {
        List<Post> rsl = new ArrayList<>();
        this.storePosts.findAll().forEach(rsl::add);
        return rsl;
    }

    public List<Comment> getAllCommentsById(int id) {
        List<Comment> rsl = new LinkedList<>();
        this.storeComments.findAllCommentById(id).forEach(rsl::add);
        return rsl;
    }
}