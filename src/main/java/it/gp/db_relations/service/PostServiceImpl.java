package it.gp.db_relations.service;

import it.gp.db_relations.model.dto.PostDTO;
import it.gp.db_relations.model.entity.Post;
import it.gp.db_relations.model.entity.User;
import it.gp.db_relations.repository.PostRepository;
import it.gp.db_relations.service.IPostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements IPostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    private PostDTO toDTO(Post post) {
        return new PostDTO(
                post.getId(),
                post.getTitle(),
                post.getMessage(),
                post.getUser().getId()
        );
    }

    private Post toEntity(PostDTO dto) {
        Post post = new Post();
        post.setId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setMessage(dto.getMessage());
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost.orElse(null);
    }

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }
}
