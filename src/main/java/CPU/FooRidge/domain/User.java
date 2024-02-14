package CPU.FooRidge.domain;


import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int userId;

    @Column(name="name",nullable = false,length=20)
    private String userName;

    @Column(name="email",nullable = false)
    private String userEmail;

    @Column(name="password",nullable = false)
    private String userPassword;

    @Column(name="address",nullable = false)
    private String userAddress;

    @Column(name="profile_img",nullable = false)
    private String userProfileImage;

    public User(int userId,String userName,String userEmail,String userPassword,String userAddress,String userProfileImage){
        this.userId=userId;
        this.userName=userName;
        this.userEmail=userEmail;
        this.userPassword=userPassword;
        this.userAddress=userAddress;
        this.userProfileImage=userProfileImage;
    }
}