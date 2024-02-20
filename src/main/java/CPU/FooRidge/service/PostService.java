package CPU.FooRidge.service;

import CPU.FooRidge.domain.Post;
import CPU.FooRidge.domain.User;
import CPU.FooRidge.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Post> getPostsByUserId(Long userId){
        return postRepository.findByUserId(userId);
    }

    public void deletePost(Long postId){
       postRepository.deleteById(postId);
    }

    public Post updatePost(Long postId,Post updatedPost){
        Optional<Post> postOptional=postRepository.findById(postId);
        if(postOptional.isPresent()){
            Post post=postOptional.get();
            post.setUserId(updatedPost.getUserId());
            post.setCategoryId(updatedPost.getCategoryId());
            post.setTradeMethod(updatedPost.getTradeMethod());
            post.setPostTitle(updatedPost.getPostTitle());
            post.setPostContent(updatedPost.getPostContent());
            return postRepository.save(post);
        }
        return null;
    }
}
