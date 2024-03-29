package com.TYR.MainPackage.Security;

import com.TYR.MainPackage.Model.Entity.AppUser;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    private final String appName = "TYR:Membership";
    private final String secretKey = "ThisIsSecretKey";
    private final long tokenExpired = 3600;

    private final Algorithm algorithm = Algorithm.HMAC256(secretKey.getBytes(StandardCharsets.UTF_8));

    public String generatedToken(AppUser appUser){
        return JWT.create()
                .withIssuer(appName)
                .withSubject(appUser.getUserId())
                .withExpiresAt(Instant.now().plusSeconds(tokenExpired))
                .withIssuedAt(Instant.now())
                .withClaim("role", appUser.getRole().name())
                .sign(algorithm);
    }

    public boolean verifyToken(String token){
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT.getIssuer().equals(appName);
    }

    public Map<String, String> getUserByToken(String token){
        try {
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            Map<String, String> userInfo = new HashMap<>();

            userInfo.put("userId", decodedJWT.getSubject());
            userInfo.put("userRole", decodedJWT.getClaim("role").asString());
            return userInfo;
        } catch (JWTVerificationException e) {
            throw new RuntimeException(e);
        }
    }
}