package com.gteam.glog.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gteam.glog.Entity.UserInfos;
import com.gteam.glog.Entity.Users;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;


@Service
public class JWTTokenUtils {

    private final String SIGN_KEY = "glog-key";
    private final String PASS_KEY = "";
    private static final long serialVersionUID = -798416586417070603L;
    private static final long JWT_TOKEN_VALIDITY = 10 * 60 * 60;
    private final ObjectMapper objectMapper = new ObjectMapper();


    /**
     * jwt 토큰에서 만효되는 날짜 조회
     *
     * @param token -
     * @return
     */
    public Date getExpirationDateFromToken(String token) {
        return getAllClaimsFromToken(token).getExpiration();
    }

    /**
     * secret 키를 가지고 토큰 내부 정보 조회
     *
     * @param token -
     * @return
     */
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(SIGN_KEY).parseClaimsJws(token).getBody();
    }

    /**
     * 토큰 만료 체크
     *
     * @param token -
     * @return
     */
    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }


    /**
     * 토큰을 생성하는 동안
     * 1. 토큰, Issuer, Expiration, Subject, ID로 claims를 정의한다.
     * 2. HS512알고리즘과 secret key를 가지고 JWT를 서명한다.
     *
     * @param claims -
     * @param username -
     * @return
     */
    private String doGenerateToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, SIGN_KEY)
                .compact();
    }

    /**
     * 헤더에 "Bearer "를 제거합니다.
     *
     * @param header -
     */
    private void validationAuthorizationHeader(String header) {
        if (header == null || !header.startsWith("Bearer ")) {
            throw new IllegalArgumentException();
        }
    }
    private String extractToken(String authorizationHeader) {
        return authorizationHeader.substring("Bearer ".length());
    }


    /**
     * users 토큰생성
     *
     * @param users
     * @return
     */
    public String generateUsersToken(Users users) {
        Map<String, Object> claims = objectMapper.convertValue(users, Map.class);
        return doGenerateToken(claims, users.getUserId());
    }

    /**
     * users Info 토큰생성
     *
     * @param userInfos -
     * @return
     */
    public String generateUserInfoToken(UserInfos userInfos) {
        Map<String, Object> claims = objectMapper.convertValue(userInfos, Map.class);
        return doGenerateToken(claims, userInfos.getUsername());
    }

    /**
     * jwt 토큰에서 유효성 검사를 위한 subject 조회
     *
     * @param token -
     * @return
     */
    public String getSubjectFromToken(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    /**
     * Users 토큰 검증
     *
     * @param token -
     * @param users -
     * @return
     */
    public Boolean validateUserToken(String token, Users users) {
        final String userId = getSubjectFromToken(token);
        return (userId.equals(users.getUserId()) && !isTokenExpired(token));
    }

    /**
     * Users Info 토큰 검증
     *
     * @param token -
     * @param userInfos -
     * @return
     */
    public Boolean validateUserInfoToken(String token, UserInfos userInfos) {
        final String username = getSubjectFromToken(token);
        return (username.equals(userInfos.getUsername()) && !isTokenExpired(token));
    }
}
