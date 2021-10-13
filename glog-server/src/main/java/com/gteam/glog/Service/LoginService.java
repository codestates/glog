package com.gteam.glog.Service;

import com.gteam.glog.Domain.BadResponseDTO;
import com.gteam.glog.Domain.UserInfoDTO;
import com.gteam.glog.Domain.UserResponseDTO;
import com.gteam.glog.Entity.Users;
import com.gteam.glog.Repository.LoginRepository;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final JWTTokenUtils jwtTokenUtils;
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
        }catch (NoSuchElementException e){
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
     */
    public Optional<Users> validateUserLogin(String token){
        if(!jwtTokenUtils.validateToken(token)){
            Claims claims = jwtTokenUtils.getAllClaimsFromToken(token);
            try{
                Optional<Users> users = loginRepository.getUsersByUserId((String)claims.get("userId"));
                // Bcrypt password validate
                return users;
            }catch (NoSuchElementException e){
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
                .ecode(400)
                .msg(_msg).build();
    }

}
