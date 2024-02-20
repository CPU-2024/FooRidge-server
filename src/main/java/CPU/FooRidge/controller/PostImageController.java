package CPU.FooRidge.controller;

import CPU.FooRidge.domain.postImage;
import CPU.FooRidge.service.PostImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postImage")
@RequiredArgsConstructor
public class PostImageController {

    private final PostImageService postImageService;

    @GetMapping
    public List<postImage> getAllImages() {
        return postImageService.findAllImages();
    }

    @PostMapping
    public ResponseEntity<postImage> addPostImage(@RequestBody postImage postImage){
        postImage createImage=postImageService.addImage(postImage);
        return new ResponseEntity<>(createImage, HttpStatus.CREATED);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deleteImage(@PathVariable("postId") Long postId){
        postImageService.deleteImage(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
