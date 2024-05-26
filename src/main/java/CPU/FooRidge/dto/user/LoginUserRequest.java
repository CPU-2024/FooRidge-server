package CPU.FooRidge.dto.user;

import CPU.FooRidge.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginUserRequest {
    private String userEmail;
    private String userPassword;

    public User toEntity(){
        return User.builder()
                .userEmail(userEmail)
                .userPassword(userPassword)
                .build();
    }
}
