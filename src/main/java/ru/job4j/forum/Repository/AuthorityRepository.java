package ru.job4j.forum.Repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
    public Authority findByAuthority(String authority);
}
