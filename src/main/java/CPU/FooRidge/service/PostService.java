package CPU.FooRidge.service;

import CPU.FooRidge.domain.Post;
import CPU.FooRidge.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post addPost(Post post){
        return postRepository.save(post);
    }
}
