package com.caolan.socialapi.service;

import com.caolan.socialapi.exception.NoPostException;
import com.caolan.socialapi.entity.Post;
import com.caolan.socialapi.repository.SocialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SocialServiceImpl implements SocialService {
    @Autowired
    private SocialRepository socialRepository;
    @Override
    public List<Post> getPosts() {
        return (List<Post>) socialRepository.findAll();
    }

    @Override
    public Optional<Post> getPostById(Long id) throws NoPostException {
        return socialRepository.findById(id);
    }

    @Override
    public void addPost(Post post) {
        socialRepository.save(post);
    }

    @Override
    public void updatePost(Post post) {
        socialRepository.save(post);
    }
    @Override
    public void deletePost(Long id) throws NoPostException {
        socialRepository.deleteById(id);
    }

}
