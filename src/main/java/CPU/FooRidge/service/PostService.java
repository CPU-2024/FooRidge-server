package CPU.FooRidge.service;

import CPU.FooRidge.domain.Post;
import CPU.FooRidge.domain.User;
import CPU.FooRidge.dto.post.AddPostRequest;
import CPU.FooRidge.dto.post.UpdatePostRequest;
import CPU.FooRidge.repository.PostRepository;
import CPU.FooRidge.repository.UserRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;


    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Post addPost(AddPostRequest dto, List<MultipartFile> files) throws IOException {
        try {
            String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

            List<String> fileNames=new ArrayList<>();

            UUID uuid = UUID.randomUUID();
            for(MultipartFile file : files){
                // UUID와 파일이름을 포함된 파일 이름 저장
                String fileName = uuid + "_" + file.getOriginalFilename();

                // projectPath는  경로, name은 전달받을 이름
                File saveFile = new File(projectPath, fileName);

                file.transferTo(saveFile);
                fileNames.add(fileName);
            }

            Post post = new Post(dto.getUser(), dto.getCategory(), dto.getPostTitle(),
                    dto.getTradeMethod(), dto.getPrice(),fileNames, dto.getPostContent());

            return postRepository.save(dto.toEntity());
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public List<Post> getPostsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found:" + userId));
        return postRepository.findByUser(user);
    }

    public void deletePost(Long postId){
       postRepository.deleteById(postId);
    }

    public Post updatePost(Long postId, UpdatePostRequest dto){
        Optional<Post> postOptional=postRepository.findById(postId);
        if(postOptional.isPresent()){
            Post post=postOptional.get();
            post.update(dto.getTradeMethod(),dto.getPrice(),dto.getPostTitle(),dto.getPostContent());
            return postRepository.save(post);
        }else{
            throw new ResourceNotFoundException("Post not found:"+postId);
        }
    }

    public List<Post> search(String keyword){
        List<Post> postsList=postRepository.findByPostTitleContaining(keyword);
        return postsList;
    }
}
