package spring.service;

import spring.exception.UserNotFoundException;
import spring.model.User;
import spring.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User createUser(User user) {
        return repository.save(user);
    }

    public User getUserById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User updateUser(long id, User user) {
        getUserById(id);
        user.setId(id);
        return repository.save(user);
    }

    public void deleteUserById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new UserNotFoundException("User with id " + id + " not found");
        }
    }
}