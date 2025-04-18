package tn.ensit.soa.Content.repositories;

import org.springframework.stereotype.Repository;
import tn.ensit.soa.Content.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.ensit.soa.Content.entities.Post;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByPost(Post post);
}
