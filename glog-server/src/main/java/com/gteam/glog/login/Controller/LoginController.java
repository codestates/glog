package com.gteam.glog.login.Controller;

import com.gteam.glog.member.Domain.OAuthRequestDTO;
import com.gteam.glog.member.Domain.UserRequestDTO;
import com.gteam.glog.member.Entity.Users;
import com.gteam.glog.login.Service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class LoginController {
    private final LoginService loginService;
    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/signin")
    @ApiOperation(value = "로그인 API", notes = "로컬 사용자 로그인 API")
    public ResponseEntity<?> singin(@RequestBody()UserRequestDTO userRequestDTO){
        try{
            Optional<Users> users = loginService.validateUserLogin(userRequestDTO.getToken());
            return ResponseEntity.ok().body(loginService.doGenerateResponseDTO(users.get(),"Login success"));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(loginService.doGenerateBadResponseDTO("Login Failed"));
        }
    }

    @PostMapping("/myinfo")
    @ApiOperation(value = "유저 정보 조회", notes = "유저 정보를 요청하는 API")
    public ResponseEntity<?> getMypage(@RequestBody()UserRequestDTO userRequestDTO){
        try{
            Optional<Users> users = loginService.validateUserLogin(userRequestDTO.getToken());
            return ResponseEntity.ok().body(loginService.doGenerateResponseDTO(users.get(),"Login success"));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(loginService.doGenerateBadResponseDTO("Login Failed"));
        }
    }

    @PostMapping("/oauth")
    @ApiOperation(value = "소셜 로그인 API", notes = "소셜 사용자 로그인 API { }")
    public ResponseEntity<?> OAuthSigin(@RequestBody() OAuthRequestDTO authorization){
        try{
            return ResponseEntity.ok().body("");
        }catch (Exception error){
            return ResponseEntity.badRequest().body("Not found!");
        }
    }
}
