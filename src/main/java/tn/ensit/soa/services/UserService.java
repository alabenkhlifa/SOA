package tn.ensit.soa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.ensit.soa.entities.Profile;
import tn.ensit.soa.entities.User;
import tn.ensit.soa.repositories.ProfileRepository;
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
    private final UserRepository userRepository;

    private final ProfileService profileService;

    @Autowired
    private ProfileRepository profileRepository;

    public UserService(UserRepository repository, ProfileService profileService) {
        this.userRepository = repository;
        this.profileService = profileService;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getOneUser(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        var createdUser = userRepository.save(user);
        var bio = "";
        Profile profile = new Profile(createdUser, bio);
        profileService.createProfile(profile);
        return createdUser;
    }
    public User register(String username, String email, String password, String bio) {
        User user = new User(username, email, password);
        user = userRepository.save(user);
        Profile profile = new Profile(user, bio);
        profileRepository.save(profile);
        return user;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
