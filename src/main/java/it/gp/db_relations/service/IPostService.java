package it.gp.db_relations.service;

import it.gp.db_relations.model.dto.PostDTO;
import it.gp.db_relations.model.entity.Post;
import java.util.List;

public interface IPostService {
    List<PostDTO> getAllPosts();
    PostDTO getPostById(Long id);
    PostDTO createPost(PostDTO postDTO);
}
