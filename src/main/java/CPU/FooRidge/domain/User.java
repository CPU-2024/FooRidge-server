package CPU.FooRidge.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int userId;

    @Column
    private String userName;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;

    @Column
    private String userAddress;

    @Column
    private String userFileName;

    @Column
    private String userFilePath;

    public User() {
    }

    @Builder
    public User(String userName, String userEmail, String userPassword, String userAddress,String userFileName,String userFilePath) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
        this.userFileName=userFileName;
        this.userFilePath=userFilePath;
    }
}
