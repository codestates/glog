package com.gteam.glog.Controller;

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

    @PostMapping("/signIn")
    @ApiOperation(value = "로그인 API", notes = "로컬 사용자 로그인 API")
    public ResponseEntity<?> singin(@RequestBody()UserRequestDTO userRequestDTO){
        try{
            Optional<Users> users = loginService.validateUserLogin(userRequestDTO.getUsr_token());
            return ResponseEntity.ok().body("");
        }catch (NoSuchElementException e){
            return ResponseEntity.badRequest().body("");
        }


    }

    @PostMapping("/oauth")
    @ApiOperation(value = "로그인 API", notes = "로컬 사용자 로그인 API")
    public ResponseEntity<?> oAuthSigin(@RequestBody()String token){
        return ResponseEntity.ok().body("");
    }
}
