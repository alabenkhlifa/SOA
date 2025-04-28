package tn.ensit.soa.post.repositories;

import org.springframework.stereotype.Repository;
import tn.ensit.soa.post.entities.Post;
import tn.ensit.soa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthor(User author);
}