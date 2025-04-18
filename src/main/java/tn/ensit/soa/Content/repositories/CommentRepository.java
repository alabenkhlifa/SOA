package tn.ensit.soa.Content.repositories;

import org.springframework.stereotype.Repository;
import tn.ensit.soa.Content.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.ensit.soa.Content.entities.Post;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
