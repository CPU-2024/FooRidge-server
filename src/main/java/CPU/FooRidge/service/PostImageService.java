package CPU.FooRidge.service;

import CPU.FooRidge.domain.postImage;
import CPU.FooRidge.repository.PostImageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostImageService {

    private final PostImageRepository postImageRepository;

    public PostImageService(PostImageRepository postImageRepository) {
        this.postImageRepository = postImageRepository;
    }

    public List<postImage> findAllImages(){
        return postImageRepository.findAll();
    }

    public postImage addImage(postImage postImage){
        return postImageRepository.save(postImage);
    }

    public void deleteImage(Long postId){
        postImageRepository.deleteById(postId);
    }
}
