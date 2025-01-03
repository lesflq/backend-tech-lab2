package uk.sevastianov.lab2.Service;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import uk.sevastianov.lab2.Entity.User;
import java.util.*;

@Service
public class UserService {
    private Map<Long, User> users = new HashMap<>();
    private Long nextId = 1L;

    public User createUser(User user) {
        user.toBuilder().id(nextId++).build();
        users.put(user.getId(), user);
        return user;
    }

    public Optional<User> getUser(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public boolean deleteUser(Long id) {
        return users.remove(id) != null;
    }
}

