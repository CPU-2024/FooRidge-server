package CPU.FooRidge.domain;

import jakarta.persistence.*;

@Entity
@Table(name="post_images")
public class postImage{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int postImageId;

    @OneToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(nullable = false)
    private String postImage;

    public postImage(){

    }
    public postImage(Post post,String postImage){
        this.post=post;
        this.postImage=postImage;
    }

    public int getPostImageId() {
        return postImageId;
    }

    public void setPostImageId(int postImageId) {
        this.postImageId = postImageId;
    }
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }
}