package CPU.FooRidge.dto.user;

import CPU.FooRidge.domain.User;

public class UserResponse {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userAddress;
    private String userFileName;
    private String userFilePath;

    public UserResponse(User user){
        this.userId=user.getUserId();
        this.userName=user.getUserName();
        this.userEmail=user.getUserEmail();
        this.userPassword=user.getUserPassword();
        this.userAddress=user.getUserAddress();
        this.userFileName=user.getUserFileName();
        this.userFilePath=user.getUserFilePath();
    }
}
