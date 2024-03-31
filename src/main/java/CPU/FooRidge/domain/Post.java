package CPU.FooRidge.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="Id")
    private int postId;

    @Column(name = "user_id",nullable = false)
    private int userId;

    @Column(name = "category_id", nullable = false)
    private int categoryId;

    @Column(nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String tradeMethod;

    @Column
    private int price;

    @ElementCollection
    @CollectionTable(name = "post_files", joinColumns = @JoinColumn(name = "post_id"))
    @Column
    private List<String> fileNames;

    @Column(nullable = false)
    private String postContent;

    public Post(){

    }
    public Post(int userId,int categoryId,String tradeMethod,String postTitle,int price,List<String> fileNames,String postContent){
        this.userId=userId;
        this.categoryId=categoryId;
        this.tradeMethod=tradeMethod;
        this.postTitle=postTitle;
        this.price=price;
        this.fileNames=fileNames;
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


    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public List<String> getFileNames() {
        return fileNames;
    }

    public void setFileNames(List<String> fileNames) {
        this.fileNames = fileNames;
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
