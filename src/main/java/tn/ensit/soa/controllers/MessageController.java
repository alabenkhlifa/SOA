package tn.ensit.soa.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.ensit.soa.dto.MessageDto;
import tn.ensit.soa.entities.Message;
import tn.ensit.soa.services.MessageService;

import java.util.List;

@RestController
@RequestMapping("messages")
public class MessageController {

    private final MessageService service;

    public MessageController(MessageService messageService) {
        this.service = messageService;
    }

    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody MessageDto dto) {
        Message savedMessage = service.saveMessage(dto);
        return ResponseEntity.ok(savedMessage);
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.ok(service.getAllMessages());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        var message = service.getMessageById(id);
        return message.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        service.deleteMessage(id);
        return ResponseEntity.ok().build();
    }
}