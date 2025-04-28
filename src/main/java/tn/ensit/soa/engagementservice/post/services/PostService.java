package tn.ensit.soa.engagementservice.post.services;

import tn.ensit.soa.engagementservice.post.entities.Post;
import tn.ensit.soa.engagementservice.post.repositories.PostRepository;
import tn.ensit.soa.userservice.user.entities.User;
import org.springframework.stereotype.Service;
import tn.ensit.soa.userservice.user.services.UserService;

import java.util.List;

@Service
public class PostService {

    private final PostRepository repository;

    private final UserService userService;

    public PostService(PostRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public Post createPost(Long authorId, String content) {
        User author = userService.findById(authorId);
        Post post = new Post(author, content);
        return repository.save(post);
    }

    public List<Post> getPostsByAuthor(Long authorId) {
        User author = userService.findById(authorId);
        return repository.findByAuthor(author);
    }

    public Post findById(Long id) {
        return repository.findById(id).orElseThrow();
    }
}