package tn.ensit.soa.engagementservice.like.services;

import tn.ensit.soa.engagementservice.like.entities.Like;
import tn.ensit.soa.engagementservice.like.repositories.LikeRepository;
import tn.ensit.soa.engagementservice.post.entities.Post;
import tn.ensit.soa.userservice.user.entities.User;
import org.springframework.stereotype.Service;
import tn.ensit.soa.engagementservice.post.services.PostService;
import tn.ensit.soa.userservice.user.services.UserService;

import java.util.List;

@Service
public class LikeService {

    private final LikeRepository repository;

    private final PostService postService;

    private final UserService userService;

    public LikeService(LikeRepository repository, PostService postService, UserService userService) {
        this.repository = repository;
        this.postService = postService;
        this.userService = userService;
    }

    public Like likePost(Long userId, Long postId) {
        User user = userService.findById(userId);
        Post post = postService.findById(postId);
        return repository.save(
            new Like(user, post)
        );
    }

    public List<Like> getLikesByPost(Long postId) {
        Post post = postService.findById(postId);
        return repository.findByPost(post);
    }
}