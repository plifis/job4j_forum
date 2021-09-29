package ru.job4j.forum.Repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
