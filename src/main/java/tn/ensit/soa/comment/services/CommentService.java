package tn.ensit.soa.comment.services;

import tn.ensit.soa.comment.entities.Comment;
import tn.ensit.soa.post.entities.Post;
import tn.ensit.soa.entities.User;
import tn.ensit.soa.comment.repositories.CommentRepository;
import org.springframework.stereotype.Service;
import tn.ensit.soa.post.services.PostService;
import tn.ensit.soa.user.services.UserService;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository repository;

    private final PostService postService;

    private final UserService userService;

    public CommentService(CommentRepository repository, PostService postService, UserService userService) {
        this.repository = repository;
        this.postService = postService;
        this.userService = userService;
    }

    public Comment addComment(Long commenterId, Long postId, String content) {
        User commenter = userService.findById(commenterId);
        Post post = postService.findById(postId);
        return repository.save(
            new Comment(commenter, post, content)
        );
    }

    public List<Comment> getCommentsByPost(Long postId) {
        Post post = postService.findById(postId);
        return repository.findByPost(post);
    }
}
