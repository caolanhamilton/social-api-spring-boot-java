package com.caolan.socialapi.service;

import com.caolan.socialapi.exception.NoPostException;
import com.caolan.socialapi.entity.Post;

import java.util.List;
import java.util.Optional;

public interface SocialService {
    List<Post> getPosts();
    Optional<Post> getPostById(Long id) throws NoPostException;
    void addPost(Post post);
    void updatePost(Post post );
    void deletePost(Long id) throws NoPostException;

}
