package com.caolan.socialapi.repository;
import com.caolan.socialapi.entity.Post;
import org.springframework.data.repository.CrudRepository;


public interface SocialRepository extends CrudRepository<Post, Long> {

}
