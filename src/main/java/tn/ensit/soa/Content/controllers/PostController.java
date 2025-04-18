package tn.ensit.soa.Content.controllers;

import tn.ensit.soa.Content.dto.PostDto;
import tn.ensit.soa.Content.entities.Post;
import tn.ensit.soa.Content.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody PostDto postDto) {
        Post post = postService.createPost(postDto.getAuthorId(), postDto.getContent());
        return ResponseEntity.ok(post);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUser(@PathVariable Long userId) {
        List<Post> posts = postService.getPostsByAuthor(userId);
        return ResponseEntity.ok(posts);
    }
}
