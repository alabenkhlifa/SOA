package tn.ensit.soa.services;

import org.springframework.stereotype.Service;
import tn.ensit.soa.entities.User;
import tn.ensit.soa.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public Optional<User> getOneUser(Long id) {
        return repository.findById(id);
    }

    public User createUser(String username) {
        User user = new User(null, username);
        return repository.save(user);
    }
}
