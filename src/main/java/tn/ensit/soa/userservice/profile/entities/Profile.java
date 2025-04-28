package tn.ensit.soa.userservice.profile.entities;

import jakarta.persistence.*;
import tn.ensit.soa.userservice.user.entities.User;

// This annotation is required to declare an entity (database table)
@Entity
public class Profile {

    // This annotation is used to declare the entity's id and it is required
    @Id
    // This annotation to ask Hibernate to generate the id automatically using a specific generation strategy
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;

    @OneToOne
    private User user;

    protected Profile() {
    }

    public Profile(String bio) {
        this.bio = bio;
    }

    public Profile(User user, String bio) {
        this.bio = bio;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", bio='" + bio + '\'' +
                ", userId='" + user.getId() + '\'' +
                '}';
    }
}