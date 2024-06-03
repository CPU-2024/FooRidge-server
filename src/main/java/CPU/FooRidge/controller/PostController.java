package CPU.FooRidge.controller;

import CPU.FooRidge.domain.Post;
import CPU.FooRidge.dto.post.AddPostRequest;
import CPU.FooRidge.dto.post.UpdatePostRequest;
import CPU.FooRidge.service.PostService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable("userId") Long userId){
        List<Post> posts=postService.getPostsByUserId(userId);
        return (posts!=null)?
                ResponseEntity.status(HttpStatus.OK).body((posts)):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Post>> search(@RequestParam("keyword") String keyword){
        List<Post> searchList=postService.search(keyword);
        return ResponseEntity.status(HttpStatus.OK).body((searchList));
    }

    @PostMapping
    public ResponseEntity<Post>  addPost(AddPostRequest dto,
                                           @RequestParam("file") List<MultipartFile> files){
        try{
           Post post=postService.addPost(dto, files);
            return ResponseEntity.ok(post);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable("postId") Long postId){
        postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable("postId") Long postId, UpdatePostRequest dto){
        postService.updatePost(postId,dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
