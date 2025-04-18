package tn.ensit.soa.repositories;

import org.springframework.stereotype.Repository;
import tn.ensit.soa.entities.Like;
import tn.ensit.soa.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByPost(Post post);
}
