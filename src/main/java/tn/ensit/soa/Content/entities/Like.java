package tn.ensit.soa.Content.entities;

import jakarta.persistence.*;
import tn.ensit.soa.User.entities.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private LocalDateTime timestamp;

    protected Like() {
    }

    public Like(User user, Post post) {
        this.user = user;
        this.post = post;
        this.timestamp = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "Like{" +
                "id=" + id +
                ", user=" + user.getId() +
                ", post=" + post.getId() +
                '}';
    }
}