package CPU.FooRidge.domain;

import jakarta.persistence.*;

@Entity
@Table(name="post_images")
public class postImage{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int postImageId;

    @Column(name="post_id",nullable = false)
    private int postId;

    @Column(name="post_image",nullable = false,length = 500)
    private String postImage;

    public postImage(int postImageId,int postId,String postImage){
        this.postImageId=postImageId;
        this.postId=postId;
        this.postImage=postImage;
    }
}