package CPU.FooRidge.service;

import CPU.FooRidge.domain.Post;
import CPU.FooRidge.domain.User;
import CPU.FooRidge.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {
    private final PostRepository postRepository;


    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void addPost(Post post, MultipartFile file) throws IOException {
        try {
            String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

            UUID uuid = UUID.randomUUID();

            // UUID와 파일이름을 포함된 파일 이름 저장
            String fileName = uuid + "_" + file.getOriginalFilename();

            // projectPath는  경로, name은 전달받을 이름
            File saveFile = new File(projectPath, fileName);

            file.transferTo(saveFile);

            post.setFileName(fileName);
            post.setFilePath("/files/" + fileName);

            postRepository.save(post);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
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
//            post.setUserId(updatedPost.getUserId());
//            post.setCategoryId(updatedPost.getCategoryId());
            post.setTradeMethod(updatedPost.getTradeMethod());
            post.setPostTitle(updatedPost.getPostTitle());
            post.setPrice(updatedPost.getPrice());
            post.setPostContent(updatedPost.getPostContent());
            return postRepository.save(post);
        }
        return null;
    }
}
