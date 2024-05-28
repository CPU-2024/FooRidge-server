package CPU.FooRidge.dto.user;

import CPU.FooRidge.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddUserRequest {
    private String userName;
    private String userEmail;
    private String userPassword;
    private String userAddress;
    private String userFileName;
    private String userFilePath;

    public User toEntity(){
        return User.builder()
                .userName(userName)
                .userEmail(userEmail)
                .userPassword(userPassword)
                .userAddress(userAddress)
                .userFileName(userFileName)
                .userFilePath(userFilePath)
                .build();
    }
}
