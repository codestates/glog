package com.gteam.glog.login.Service;

import com.gteam.glog.auth.Service.JWTTokenUtils;
import com.gteam.glog.member.Domain.BadResponseDTO;
import com.gteam.glog.member.Domain.UserInfoDTO;
import com.gteam.glog.member.Domain.UserResponseDTO;
import com.gteam.glog.member.Entity.Users;
import com.gteam.glog.login.Repository.LoginRepository;
import io.jsonwebtoken.Claims;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final JWTTokenUtils jwtTokenUtils;
    PasswordEncoder passwordEncoder;
    public LoginService(LoginRepository loginRepository, JWTTokenUtils jwtTokenUtils) {
        this.loginRepository = loginRepository;
        this.jwtTokenUtils = jwtTokenUtils;
    }

    /**
     *  User checking by Id
     *
     * @param id - user id
     * @return :
     *          > userId is used       - return user info
     *          > userId is not used   - return null
     */
    public UserInfoDTO findUserByUserId(String id){
        try{
            return loginRepository.getUserInfoByUserId(id).get();
        }catch (NoSuchElementException e){
            return null;
        }
    }

    /**
     *  User checking by Id
     *
     * @param id - userinfo id
     * @return :
     *          >  userId is used       - return user info
     *          >  userId is not used   - return null
     */
    public UserInfoDTO findUserInfoByUserId(String id){
        try{
            return loginRepository.getUserInfoByUserId(id).get();
        }catch (IllegalArgumentException e){
            return null;
        }
    }

    /**
     * 로그인 검증
     *  1. 토큰 유효성 검사
     *  2. 회원 조회
     *  3. 비밀번호 확인
     *
     * @param token -
     * @return :
     *       >  all correct    : UserIdx, userId
     *       >  is not correct : optional Empty()
     */
    public Optional<Users> validateUserLogin(String token){
        if(!jwtTokenUtils.validateToken(token)){
            Claims claims = jwtTokenUtils.getAllClaimsFromToken(token);
            try{
                Optional<Users> users = loginRepository.getUsersByUserId((String)claims.get("userId"));

                // Bcrypt password validate
                if(!passwordEncoder.matches((String)claims.get("userToken"),users.get().getUserToken())){
                    return Optional.empty();
                }
                return users;
            }catch (IllegalArgumentException e){
                return Optional.empty();
            }
        }else{
            return Optional.empty();
        }
    }

    /**
     * Generater ResponseDTO
     *
     * @param users - users 정보
     * @param _msg  - 응답 메시지
     * @return - UserResponseDTO
     */
    public UserResponseDTO doGenerateResponseDTO(Users users, String _msg){
        return UserResponseDTO.builder()
                .useridx(users.getIdx())
                .userId(users.getUserId())
                .msg(_msg)
                .build();
    }

    /**
     * Generater Bad ResponseDTO
     *
     * @param _msg  - 응답 메시지
     * @return - UserResponseDTO
     */
    public BadResponseDTO doGenerateBadResponseDTO(String _msg){
        return BadResponseDTO.builder()
                .ecode(203)
                .msg(_msg).build();
    }

}
