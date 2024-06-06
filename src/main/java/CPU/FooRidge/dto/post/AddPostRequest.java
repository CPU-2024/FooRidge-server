package CPU.FooRidge.dto.post;

import CPU.FooRidge.domain.Category;
import CPU.FooRidge.domain.Post;
import CPU.FooRidge.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddPostRequest {
    private User user;
    private Category category;
    private String tradeMethod;
    private Long price;
    private String postTitle;
    private String postContent;

    public Post toEntity(){
        return Post.builder()
                .user(user)
                .category(category)
                .tradeMethod(tradeMethod)
                .price(price)
                .postTitle(postTitle)
                .postContent(postContent)
                .build();
    }
}
