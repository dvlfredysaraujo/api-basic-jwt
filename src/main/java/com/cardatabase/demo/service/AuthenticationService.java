package com.cardatabase.demo.service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

public class AuthenticationService {
    static final long EXPIRATIONTIME = 864_000_00;
    static final String SIGNINGKEY = "SecretKey";
    static final String PREFIX = "Bearer";

    // Add token to Authorization header
    public static void addToken(HttpServletResponse res, String username){
        String JwToken = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()
                + EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, SIGNINGKEY)
                .compact();
        res.addHeader("Authorization", PREFIX + " " + JwToken);
        res.addHeader("Access-Control-Expose-Headers", "Authorization");
    }

    // Get token from Authorization header
    public static Authentication getAuthentication(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if (token != null){
            String user = Jwts.parser()
                    .setSigningKey(SIGNINGKEY)
                    .parseClaimsJws(token.replace(PREFIX, ""))
                    .getBody()
                    .getSubject();

            if (user != null){
                return new UsernamePasswordAuthenticationToken(user, null, emptyList());
            }
        }
        return null;
    }
}
