package CPU.FooRidge.domain;

import jakarta.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int postId;

    @JoinColumn(name = "user", referencedColumnName = "id",nullable = false)
    private User userId;

    @JoinColumn(name = "category", referencedColumnName = "id",nullable = false)
    private Category categoryId;

    @Column(nullable = false)
    private String tradeMethod;

    @Column(nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String postContent;

    public Post(){

    }
    public Post(User userId,Category categoryId,String tradeMethod,String postTitle,String postContent){
        this.userId=userId;
        this.categoryId=categoryId;
        this.tradeMethod=tradeMethod;
        this.postTitle=postTitle;
        this.postContent=postContent;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public String getTradeMethod() {
        return tradeMethod;
    }

    public void setTradeMethod(String tradeMethod) {
        this.tradeMethod = tradeMethod;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
            this.postContent = postContent;
    }
}
