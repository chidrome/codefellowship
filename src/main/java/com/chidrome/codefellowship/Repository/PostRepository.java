package com.chidrome.codefellowship.Repository;

import com.chidrome.codefellowship.Models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
