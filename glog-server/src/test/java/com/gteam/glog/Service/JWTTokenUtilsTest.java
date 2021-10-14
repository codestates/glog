package com.gteam.glog.Service;

import com.gteam.glog.Entity.Users;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("test")
class JWTTokenUtilsTest {
    private final JWTTokenUtils jwtTokenUtils;
//    JWTTokenUtils jwtTokenUtils;
    @Autowired
    JWTTokenUtilsTest(JWTTokenUtils jwtTokenUtils) {
        this.jwtTokenUtils = jwtTokenUtils;
    }

    @BeforeEach
    public void befor(){
//        jwtTokenUtils = new JWTTokenUtils();
    }

    @Test
    void tokenTest() {
        Users users = new Users();
        users.setUserToken("testpassword");
        users.setUserId("testid");

        String tesToken = jwtTokenUtils.generateObjectToken(users);
        Claims claims = jwtTokenUtils.getAllClaimsFromToken(tesToken);

        System.out.printf("\n\n");
        System.out.printf("Test Token : "+tesToken);
        System.out.printf("\n\n");
        System.out.printf("Test user id : "+claims.get("userId"));
        System.out.printf("\n\n");

        assertThat(jwtTokenUtils.validateToken(tesToken)).isTrue();
        assertThat(jwtTokenUtils.getAllClaimsFromToken(tesToken).get("userId")).isEqualTo(users.getUserId());
    }

    private class ServerConfig {
    }
}