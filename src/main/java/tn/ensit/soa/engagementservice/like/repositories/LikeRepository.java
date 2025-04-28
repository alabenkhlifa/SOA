package tn.ensit.soa.engagementservice.like.repositories;

import org.springframework.stereotype.Repository;
import tn.ensit.soa.engagementservice.like.entities.Like;
import tn.ensit.soa.engagementservice.post.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByPost(Post post);
}
