package tn.ensit.soa.services;

import tn.ensit.soa.entities.Like;
import tn.ensit.soa.repositories.LikeRepository;
import tn.ensit.soa.entities.Post;
import tn.ensit.soa.entities.User;
import tn.ensit.soa.repositories.PostRepository;
import tn.ensit.soa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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