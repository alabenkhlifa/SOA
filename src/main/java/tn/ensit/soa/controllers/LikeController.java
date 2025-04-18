package tn.ensit.soa.controllers;

import tn.ensit.soa.dto.LikeDto;
import tn.ensit.soa.entities.Like;
import tn.ensit.soa.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping("/add")
    public ResponseEntity<Like> addLike(@RequestBody LikeDto likeDto) {
        Like like = likeService.likePost(likeDto.getUserId(), likeDto.getPostId());
        return ResponseEntity.ok(like);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Like>> getLikesByPost(@PathVariable Long postId) {
        List<Like> likes = likeService.getLikesByPost(postId);
        return ResponseEntity.ok(likes);
    }
}