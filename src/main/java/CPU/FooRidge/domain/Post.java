package CPU.FooRidge.domain;

import jakarta.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int postId;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private int categoryId;

    @Column(nullable = false)
    private String tradeMethod;

    @Column(nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String postContent;

    public Post(){

    }
    public Post(int userId,int categoryId,String tradeMethod,String postTitle,String postContent){
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
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
