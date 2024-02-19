package CPU.FooRidge.controller;

import CPU.FooRidge.domain.postImage;
import CPU.FooRidge.service.PostImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
