package com.gteam.glog.Controller;

import com.gteam.glog.Domain.UserInfoDTO;
import com.gteam.glog.Service.JWTTokenUtils;
import com.gteam.glog.Service.RegisterService;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class RegisterController {

    private final RegisterService registerService;
    private JWTTokenUtils jwtTokenUtils;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping(value = "/signup")
    @ApiOperation(value = "회원가입 API", notes = "로컬 사용자 회원가입 API")
    public String createUserinfo(@RequestBody(required = true)String token, HttpServletResponse response) {

        UserInfoDTO userInfoDTO = new UserInfoDTO();
        Claims claims = jwtTokenUtils.getAllClaimsFromToken(token);

        userInfoDTO.setUserId((String) claims.get("email"));
        userInfoDTO.setUserToken((String) claims.get("password"));
        userInfoDTO.setUserName((String) claims.get("nickname"));

        return registerService.createUserInfo(userInfoDTO);
    }

    @PostMapping(value = "/gitOauth")
    @ApiOperation(value = "소셜 회원가입 API", notes = "소셜 계정 사용자 회원등록 API")
    public String createOauthGitUserInfo() {


        return null;
    }

    @PostMapping(value = "/googleOauth")
    @ApiOperation(value = "소셜 회원가입 API", notes = "소셜 계정 사용자 회원등록 API")
    public String createOauthGoogleUserInfo() {


        return null;
    }

}
