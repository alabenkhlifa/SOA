package tn.ensit.soa.engagementservice.comment.entities;

import jakarta.persistence.*;
import tn.ensit.soa.engagementservice.post.entities.Post;
import tn.ensit.soa.userservice.user.entities.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "post_comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User commenter;

    private String content;
    private LocalDateTime timestamp;

    public Comment() {
    }

    public Comment(User commenter, Post post, String content) {
        this.commenter = commenter;
        this.post = post;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getCommenter() {
        return commenter;
    }

    public void setCommenter(User commenter) {
        this.commenter = commenter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", postId=" + post.getId() +
                ", commenterId=" + commenter.getId() +
                ", content='" + content + '\'' +
                '}';
    }
}