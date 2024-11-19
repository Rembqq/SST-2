package org.study.sst2.repository;

import org.study.sst2.models.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {
    private final Map<Long, User> users = new HashMap<>();
    //private Long idCounter = 1L;
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

//    public User save(User user) {
//        user.setId(idCounter++);
//        users.put(user.getId(), user);
//        return user;
//    }

    public User save(User user) {
        user.setId(idCounter.incrementAndGet());
        users.put(user.getId(), user);
        return user;
    }

    public void deleteById(Long id) {
        users.remove(id);
    }
}
