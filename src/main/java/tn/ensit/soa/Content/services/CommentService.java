package tn.ensit.soa.Content.services;

import tn.ensit.soa.Content.entities.Comment;
import tn.ensit.soa.Content.entities.Post;
import tn.ensit.soa.Content.repositories.CommentRepository;
import tn.ensit.soa.Content.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.ensit.soa.User.entities.User;
import tn.ensit.soa.User.repositories.UserRepository;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Comment commentPost(Long commenterId, Long postId, String content) {
        User commenter = userRepository.findById(commenterId).orElseThrow();
        Post post = postRepository.findById(postId).orElseThrow();
        Comment comment = new Comment(commenter, post, content);
        return commentRepository.save(comment);
    }

    public List<Comment> getCommentsByPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow();
        return commentRepository.findByPost(post);
    }
}
