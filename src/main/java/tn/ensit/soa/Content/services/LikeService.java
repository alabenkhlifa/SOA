package tn.ensit.soa.Content.services;

import tn.ensit.soa.Content.entities.Like;
import tn.ensit.soa.Content.entities.Post;
import tn.ensit.soa.Content.repositories.LikeRepository;
import org.springframework.stereotype.Service;
import tn.ensit.soa.User.entities.User;
import tn.ensit.soa.User.services.UserService;

import java.util.List;

@Service
public class LikeService {

    private final LikeRepository repository;

    private final PostService postService;

    private final UserService userService;

    public LikeService(LikeRepository likeRepository, PostService postService, UserService userService) {
        this.repository = likeRepository;
        this.postService = postService;
        this.userService = userService;
    }

    public Like likePost(Long userId, Long postId) {
        User user = userService.findById(userId);
        Post post = postService.findById(postId);
        Like like = new Like(user, post);
        return repository.save(like);
    }

    public List<Like> getLikesByPost(Long postId) {
        Post post = postService.findById(postId);
        return repository.findByPost(post);
    }
}