package org.adaschool.api.service.user;

import org.adaschool.api.repository.user.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsersServiceMap implements UsersService {

    private final Map<String, User> userMap = new HashMap<>();

    @Override
    public User save(User user) {
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(String id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public List<User> all() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public void deleteById(String id) {
        userMap.remove(id);
    }

    @Override
    public User update(User user, String userId) {
        if (userMap.containsKey(userId)) {
            userMap.put(userId, user);
            return user;
        }
        return null;
    }
}