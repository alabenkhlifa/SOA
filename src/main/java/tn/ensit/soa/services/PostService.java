package tn.ensit.soa.services;

import tn.ensit.soa.entities.Post;
import tn.ensit.soa.repositories.PostRepository;
import tn.ensit.soa.entities.User;
import tn.ensit.soa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Post createPost(Long authorId, String content) {
        User author = userRepository.findById(authorId).orElseThrow();
        Post post = new Post(author, content);
        return postRepository.save(post);
    }

    public List<Post> getPostsByAuthor(Long authorId) {
        User author = userRepository.findById(authorId).orElseThrow();
        return postRepository.findByAuthor(author);
    }
}