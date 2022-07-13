package ml.empee.angularShop.controller.authentication;

import ml.empee.angularShop.security.dto.AuthenticationRequest;
import ml.empee.angularShop.security.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class LoginController {
    private final AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(
                authenticationService.authenticateUser(authenticationRequest)
        );
    }
}
