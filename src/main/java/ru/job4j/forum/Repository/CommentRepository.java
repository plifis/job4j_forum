package ru.job4j.forum.Repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Comment;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    public List<Comment> findAllCommentById(int id);
}
