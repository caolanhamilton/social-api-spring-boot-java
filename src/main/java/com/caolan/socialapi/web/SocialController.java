package com.caolan.socialapi.web;

import com.caolan.socialapi.exception.NoPostException;
import com.caolan.socialapi.entity.Post;
import com.caolan.socialapi.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SocialController {
    @Autowired
    private SocialService socialService;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = socialService.getPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Optional<Post>> getPost(@PathVariable Long id) throws NoPostException {
        try {
            Optional<Post> post = socialService.getPostById(id);
            return new ResponseEntity<>(post, HttpStatus.OK);
        } catch (NoPostException error) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/posts")
    public ResponseEntity<HttpStatus> createPost(@RequestBody Post post) {
        socialService.addPost(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable Long id) throws NoPostException {
        try {
            socialService.deletePost(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (NoPostException error) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable String id, @RequestBody Post post) {
            socialService.updatePost(post);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
