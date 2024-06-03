package CPU.FooRidge.dto.post;

import CPU.FooRidge.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdatePostRequest {
    private String tradeMethod;
    private Long price;
    private String postTitle;
    private String postContent;

    public Post toEntity(){
        return Post.builder()
                .tradeMethod(tradeMethod)
                .price(price)
                .postTitle(postTitle)
                .postContent(postContent)
                .build();
    }
}
