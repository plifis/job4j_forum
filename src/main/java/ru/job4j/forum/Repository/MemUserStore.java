package ru.job4j.forum.Repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MemUserStore {
    private final Map<Integer, User> mem = new HashMap<>();
    private static final AtomicInteger COUNT = new AtomicInteger(0);

    private MemUserStore() {
        this.mem.put(COUNT.incrementAndGet(), new User("Nikita", "nik@gmail.com", "123"));
    }

    public User findUserByUsername(String name) {
        for (User temp : this.mem.values()) {
            if (temp.getName().equals(name)) {
                return temp;
            }
        }
        return null;
    }

    public void save(User user) {
        this.mem.put(COUNT.incrementAndGet(), user);
    }

    public Collection<User> getAll() {
        return this.mem.values();
    }
}
