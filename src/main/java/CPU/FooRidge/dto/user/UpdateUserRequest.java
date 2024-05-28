package CPU.FooRidge.dto.user;

import CPU.FooRidge.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateUserRequest { ;
    private String userAddress;

    public User toEntity(){
        return User.builder()
                .userAddress(userAddress)
                .build();
    }
}
