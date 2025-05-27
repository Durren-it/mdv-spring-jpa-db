package it.gp.db_relations.service;

import it.gp.db_relations.model.entity.Post;
import java.util.List;

public interface IPostService {
    List<Post> getAllPosts();
    Post getPostById(Long id);
    Post createPost(Post post);
}
