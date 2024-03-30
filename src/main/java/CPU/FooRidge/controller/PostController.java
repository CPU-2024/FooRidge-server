package CPU.FooRidge.controller;

import CPU.FooRidge.domain.Post;
import CPU.FooRidge.domain.User;
import CPU.FooRidge.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
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
    public List<Post> getPostsByUserId(@PathVariable("userId") Long userId){
        return postService.getPostsByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<String>  addPost(@RequestParam("postTitle") String postTitle,
                                           @RequestParam("tradeMethod") String tradeMethod,
                                           @RequestParam("price") int price,
                                           @RequestParam("postContent") String postContent,
                                           @RequestParam("file") MultipartFile file){
        try{
            Post post=new Post();
            post.setPostTitle(postTitle);
            post.setTradeMethod(tradeMethod);
            post.setPrice(price);
            post.setPostContent(postContent);
            postService.addPost(post,file);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable("postId") Long postId){
        postService.deletePost(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable("postId") Long postId,@RequestBody Post updatedpost){
        postService.updatePost(postId,updatedpost);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
