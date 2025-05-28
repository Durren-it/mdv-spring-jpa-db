package it.gp.db_relations.service;

import it.gp.db_relations.model.dto.PostDTO;
import it.gp.db_relations.model.entity.Post;
import it.gp.db_relations.model.entity.User;
import it.gp.db_relations.repository.PostRepository;
import it.gp.db_relations.service.IPostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    // FIXME: MAPPING PER DATI MANCANTI
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
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().stream()
                .map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostById(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost.map(this::toDTO).orElseThrow();
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        return toDTO(postRepository.save(
                toEntity(postDTO)
        ));
    }
}
