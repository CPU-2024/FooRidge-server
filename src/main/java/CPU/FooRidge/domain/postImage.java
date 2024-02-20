package CPU.FooRidge.domain;

import jakarta.persistence.*;

@Entity
@Table(name="post_images")
public class postImage{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int postImageId;

    @JoinColumn(name = "post", referencedColumnName = "id",nullable = false)
    private int postId;

    @Column(nullable = false)
    private String postImage;

    public postImage(){

    }
    public postImage(int postId,String postImage){
        this.postId=postId;
        this.postImage=postImage;
    }

    public int getPostImageId() {
        return postImageId;
    }

    public void setPostImageId(int postImageId) {
        this.postImageId = postImageId;
    }
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }
}