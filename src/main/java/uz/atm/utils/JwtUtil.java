package uz.atm.utils;

import io.jsonwebtoken.*;
import uz.atm.dto.auth.JwtDTO;
import uz.atm.enums.Role;
import uz.atm.exceptions.AppBadRequestException;

import java.util.*;

public class JwtUtil {

    private final static String secretKey = "key finance";


    public static String encode(String phone, Role role) {
        JwtBuilder jwtBuilder = Jwts.builder();

        jwtBuilder.setSubject(phone);
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.signWith(SignatureAlgorithm.HS256, secretKey);
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + (60 * 60 * 1000 * 24)));
        if (Optional.ofNullable(role).isPresent()) {
            jwtBuilder.claim("role", role);
        }


        return jwtBuilder.compact();
    }

    public static JwtDTO decode(String jwt) {
        try {
            JwtParser jwtParser = Jwts.parser();

            jwtParser.setSigningKey(secretKey);
            Jws<Claims> jws = jwtParser.parseClaimsJws(jwt);

            Claims claims = jws.getBody();

            String username = claims.getSubject();
            String role = String.valueOf(claims.get("role"));

            return new JwtDTO(username, role);

        } catch (JwtException e) {
            throw new AppBadRequestException("JWT invalid!");
        }
    }

}
