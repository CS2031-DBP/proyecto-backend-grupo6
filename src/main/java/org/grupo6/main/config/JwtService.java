package org.grupo6.main.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String SECRET_KEY;

    public String generateToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 864_000_000)) // 10 días de expiración
                .sign(Algorithm.HMAC512(SECRET_KEY.getBytes()));
    }

    public String validateToken(String token) {
        return JWT.require(Algorithm.HMAC512(SECRET_KEY.getBytes()))
                .build()
                .verify(token)
                .getSubject();
    }
}