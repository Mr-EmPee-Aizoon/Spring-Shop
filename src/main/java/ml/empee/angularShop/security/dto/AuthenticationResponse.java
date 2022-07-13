package ml.empee.angularShop.security.dto;

import lombok.Data;
import ml.empee.angularShop.model.user.dto.UserResponse;

@Data
public class AuthenticationResponse {
    private String jwtToken;
    private UserResponse user;

    public AuthenticationResponse(String jwtToken, UserResponse user) {
        this.jwtToken = jwtToken;
        this.user = user;
    }

}
