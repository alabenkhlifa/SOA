package tn.ensit.soa.Content.services;

import tn.ensit.soa.Content.entities.Post;
import tn.ensit.soa.Content.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.ensit.soa.User.entities.User;
import tn.ensit.soa.User.repositories.UserRepository;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Post createPost(Long authorId, String content) {
        User author = userRepository.findById(authorId).orElseThrow();
        Post post = new Post(author, content);
        return postRepository.save(post);
    }

    public List<Post> getPostsByAuthor(Long authorId) {
        User author = userRepository.findById(authorId).orElseThrow();
        return postRepository.findByAuthor(author);
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow();
    }
}