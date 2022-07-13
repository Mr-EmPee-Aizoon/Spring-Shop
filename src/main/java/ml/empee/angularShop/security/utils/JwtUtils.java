package ml.empee.angularShop.security.utils;

import io.jsonwebtoken.*;
import ml.empee.angularShop.model.user.dto.UserResponse;

import java.util.Date;
import java.util.concurrent.TimeUnit;
public final class JwtUtils {

    private static final String hardcodedJwtSecret = "mySecret";
    private static final long jwtExpirationMs = TimeUnit.HOURS.toMillis(2L);

    public static String generateJwtToken(UserResponse user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, hardcodedJwtSecret)
                .compact();
    }

    public static Jws<Claims> parseToken(String token) {
        if(token == null) return null;

        try {
            return Jwts.parser().setSigningKey(hardcodedJwtSecret).parseClaimsJws(token);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String extractUsername(Jws<Claims> token) {
        return token.getBody().getSubject();
    }

}
