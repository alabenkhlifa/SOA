package tn.ensit.soa.comment.repositories;

import org.springframework.stereotype.Repository;
import tn.ensit.soa.comment.entities.Comment;
import tn.ensit.soa.post.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
