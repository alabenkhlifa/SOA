package tn.ensit.soa.Content.services;

import tn.ensit.soa.Content.entities.Like;
import tn.ensit.soa.Content.entities.Post;
import tn.ensit.soa.Content.repositories.LikeRepository;
import tn.ensit.soa.Content.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.ensit.soa.User.entities.User;
import tn.ensit.soa.User.repositories.UserRepository;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Like likePost(Long userId, Long postId) {
        User user = userRepository.findById(userId).orElseThrow();
        Post post = postRepository.findById(postId).orElseThrow();
        Like like = new Like(user, post);
        return likeRepository.save(like);
    }

    public List<Like> getLikesByPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow();
        return likeRepository.findByPost(post);
    }
}