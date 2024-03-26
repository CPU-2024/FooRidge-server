package CPU.FooRidge.domain;

import jakarta.persistence.*;

@Entity
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

    public User(String userName, String userEmail, String userPassword, String userAddress,String userFileName,String userFilePath) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userAddress = userAddress;
        this.userFileName=userFileName;
        this.userFilePath=userFilePath;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserFileName() { return userFileName; }

    public void setUserFileName(String userFileName) {
        this.userFileName = userFileName;
    }

    public String getUserFilePath() {
        return userFilePath;
    }

    public void setUserFilePath(String userFilePath) {
        this.userFilePath = userFilePath;
    }
}
