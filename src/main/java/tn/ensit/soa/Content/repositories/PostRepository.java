package tn.ensit.soa.Content.repositories;

import org.springframework.stereotype.Repository;
import tn.ensit.soa.Content.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.ensit.soa.User.entities.User;

import java.util.List;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByAuthor(User author);
}