package CPU.FooRidge.service;

import CPU.FooRidge.domain.Post;
import CPU.FooRidge.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post addPost(Post post){
        return postRepository.save(post);
    }

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }
}
