package tn.ensit.soa.controllers;

import tn.ensit.soa.dto.CommentDto;
import tn.ensit.soa.entities.Comment;
import tn.ensit.soa.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public ResponseEntity<Comment> addComment(@RequestBody CommentDto commentDto) {
        Comment comment = commentService.commentPost(commentDto.getCommenterId(), commentDto.getPostId(), commentDto.getContent());
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPost(@PathVariable Long postId) {
        List<Comment> comments = commentService.getCommentsByPost(postId);
        return ResponseEntity.ok(comments);
    }
}