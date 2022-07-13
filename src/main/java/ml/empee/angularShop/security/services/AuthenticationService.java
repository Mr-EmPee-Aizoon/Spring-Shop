package ml.empee.angularShop.security.services;

import ml.empee.angularShop.model.user.dto.UserResponse;
import ml.empee.angularShop.security.dto.AuthenticationRequest;
import ml.empee.angularShop.security.dto.AuthenticationResponse;
import ml.empee.angularShop.security.utils.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse authenticateUser(AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserResponse user = (UserResponse) authentication.getPrincipal();

        return new AuthenticationResponse(
                JwtUtils.generateJwtToken(user),
                user
        );
    }

}
