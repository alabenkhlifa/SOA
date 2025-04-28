package tn.ensit.soa.engagementservice.comment.repositories;

import org.springframework.stereotype.Repository;
import tn.ensit.soa.engagementservice.comment.entities.Comment;
import tn.ensit.soa.engagementservice.post.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
