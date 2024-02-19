package CPU.FooRidge.controller;

import CPU.FooRidge.domain.Post;
import CPU.FooRidge.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> addPost(@RequestBody Post post){
        Post createPost=postService.addPost(post);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

}
