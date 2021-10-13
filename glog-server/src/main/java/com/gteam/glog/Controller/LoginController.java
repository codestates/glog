package com.gteam.glog.Controller;

import com.gteam.glog.Domain.OAuthRequestDTO;
import com.gteam.glog.Domain.UserRequestDTO;
import com.gteam.glog.Entity.Users;
import com.gteam.glog.Service.LoginService;
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
        }catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body(loginService.doGenerateBadResponseDTO(e.getMessage()));
        }


    }

    @PostMapping("/oauth")
    @ApiOperation(value = "쇼셜 로그인 API", notes = "쇼셜 사용자 로그인 API { }")
    public ResponseEntity<?> OAuthSigin(@RequestBody() OAuthRequestDTO authorization){
        try{
            System.out.println(authorization.getAuthorizationCode());

            return ResponseEntity.ok().body("");
        }catch (Exception error){
            return ResponseEntity.badRequest().body("Not found!");
        }
    }
}
