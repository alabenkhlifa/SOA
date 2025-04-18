package tn.ensit.soa.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    private LocalDateTime timestamp;

    public Like() {
    }

    public Like(User user, Post post) {
        this.user = user;
        this.post = post;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", postId=" + post.getId() +
                '}';
    }
}