package ml.empee.angularShop.security.filters;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import ml.empee.angularShop.model.user.UserService;
import ml.empee.angularShop.model.user.dto.UserResponse;
import ml.empee.angularShop.security.utils.JwtUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private final UserService userService;

    public JwtTokenFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Jws<Claims> jwtToken = JwtUtils.parseToken(getJwt(request));

        if(jwtToken != null) {
            UserResponse userDetails = userService.loadUserByUsername(JwtUtils.extractUsername(jwtToken));

            if(userDetails != null) {
                UsernamePasswordAuthenticationToken authentication = userDetails.wrapIntoAuthenticationToken();

                SecurityContextHolder.getContext().setAuthentication(
                        authentication
                );
            }
        }

        filterChain.doFilter(request, response);
    }


    private String getJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (headerAuth != null && !headerAuth.isBlank()) {
            return headerAuth;
        }

        return null;
    }

}
