package tn.ensit.soa.services;

import org.springframework.stereotype.Service;
import tn.ensit.soa.entities.User;
import tn.ensit.soa.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

// This annotation is required to declare a Service
@Service
public class UserService {

    // We are injecting the repository using the constructor (constructor based injection)
    // We don't need to initialize (or create) the repo ourselves, the Spring Framework will do it for us
    // Optionally we could have added an annotation @Autowired to specifically ask Spring to inject this field
    // But we didn't need it because Spring Framework is smart
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

    public User createUser(User user) {
        return repository.save(user);
    }
}
