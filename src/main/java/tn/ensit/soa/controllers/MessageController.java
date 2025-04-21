package tn.ensit.soa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.ensit.soa.dto.MessageDto;
import tn.ensit.soa.entities.Message;
import tn.ensit.soa.entities.User;
import tn.ensit.soa.services.MessageService;
import tn.ensit.soa.services.UserService;

import java.util.List;

@RestController
@RequestMapping("messages")
public class MessageController {

    private final MessageService messageService;

    private final UserService userService;

    public MessageController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @PostMapping("/send")
    public ResponseEntity<Message> createMessage(@RequestBody MessageDto dto) {
        Message savedMessage = messageService.saveMessage(dto);
        return ResponseEntity.ok(savedMessage);
    }

    @GetMapping("/between/{senderId}/{receiverId}")
    public ResponseEntity<List<Message>> getMessagesBetween(@PathVariable Long senderId, @PathVariable Long receiverId) {
        User sender = userService.findById(senderId);
        User receiver = userService.findById(receiverId);
        List<Message> messages = messageService.getMessagesBetween(sender, receiver);
        return ResponseEntity.ok(messages);
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        var message = messageService.getMessageById(id);
        return message.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.ok().build();
    }
}