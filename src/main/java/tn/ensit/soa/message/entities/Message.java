package tn.ensit.soa.message.entities;

import jakarta.persistence.*;
import tn.ensit.soa.entities.User;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String channelId;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User sender;

    @ManyToOne
    private User receiver;
    public Message() {}

    public Message(String channelId, User sender, User receiver) {
        this.channelId = channelId;
        this.sender = sender;
        this.receiver = receiver;
    }
    public Message(String channelId, User receiver) {
        this.channelId = channelId;
        this.receiver = receiver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", channelId='" + channelId + '\'' +
                ", sender=" + sender +
                ", receiver=" + receiver +
                '}';
    }
}