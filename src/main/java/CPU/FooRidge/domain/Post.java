package CPU.FooRidge.domain;

import jakarta.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int postId;

    @Column(name="user_id",nullable = false)
    private int userId;

    @Column(name="category_id",nullable = false)
    private int categoryId;

    @Column(name="trade_method",nullable = false,length = 20)
    private String tradeMethod;

    @Column(name="title",nullable = false)
    private String postTitle;

    @Column(name="content",nullable = false,length = 500)
    private String postContent;

    public Post(int postId,int userId,int categoryId,String tradeMethod,String postTitle,String postContent){
        this.postId=postId;
        this.userId=userId;
        this.categoryId=categoryId;
        this.tradeMethod=tradeMethod;
        this.postTitle=postTitle;
        this.postContent=postContent;
    }
}
