package com.teamproject1.scuoledevelhope.utils;

import com.bananapilot.samplespringauthenticationframework.utils.JWTUtils;
import com.teamproject1.scuoledevelhope.classes.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Utils {
    @Autowired
    JWTUtils jwtUtils;

    public User getUserFromJwt(String jwt) {
        Jws<Claims> claimsJws = jwtUtils.validate(jwt.split(" ")[1]);
        return User.UserBuilder.anUser()
                .withId(claimsJws.getBody().get("user-id", Long.class))
                .withUsername(claimsJws.getBody().get("user-username", String.class))
                .withRoles(claimsJws.getBody().get("user-roles", List.class))
                .build();
    }
}