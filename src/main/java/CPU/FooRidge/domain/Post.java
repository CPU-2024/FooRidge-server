package CPU.FooRidge.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int postId;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne
    @JoinColumn(name="category_id")
    private Category category;

    @Column(nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String tradeMethod;

    @Column
    private Long price;

    @ElementCollection
    @CollectionTable(name = "post_files", joinColumns = @JoinColumn(name = "post_id"))
    @Column
    private List<String> fileNames;

    @Column(nullable = false)
    private String postContent;

    public Post(){

    }

    @Builder
    public Post(User user,Category category,String tradeMethod,String postTitle,Long price,List<String> fileNames,String postContent){
        this.user=user;
        this.category=category;
        this.tradeMethod=tradeMethod;
        this.price=price;
        this.postTitle=postTitle;
        this.fileNames=fileNames;
        this.postContent=postContent;
    }

    public void update(String tradeMethod, Long price, String postTitle, String postContent) {
        this.tradeMethod=tradeMethod;
        this.price=price;
        this.postTitle=postTitle;
        this.postContent=postContent;
    }


}
