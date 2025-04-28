package tn.ensit.soa.engagementservice.comment.controllers;

import tn.ensit.soa.engagementservice.comment.dto.CommentDto;
import tn.ensit.soa.engagementservice.comment.entities.Comment;
import tn.ensit.soa.engagementservice.comment.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestBody CommentDto commentDto) {
        Comment comment = commentService.addComment(commentDto.getCommenterId(), commentDto.getPostId(), commentDto.getContent());
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPost(@PathVariable Long postId) {
        List<Comment> comments = commentService.getCommentsByPost(postId);
        return ResponseEntity.ok(comments);
    }
}