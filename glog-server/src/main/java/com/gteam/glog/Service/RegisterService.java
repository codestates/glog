package com.gteam.glog.Service;

import com.gteam.glog.Domain.UserInfoDTO;
import com.gteam.glog.Repository.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final RegisterRepository registerRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }

    public String createUserInfo(UserInfoDTO userInfoDTO) {

        UserInfoDTO setUserData = new UserInfoDTO();

        setUserData.setUserId(userInfoDTO.getUserId());
        setUserData.setName(userInfoDTO.getName());
        setUserData.setToken(passwordEncoder.encode(userInfoDTO.getToken()));

        registerRepository.createUserInfo(setUserData);

        if(!registerRepository.duplicateCheck(userInfoDTO.getUserId())) {
            return "success";
        }

        return "false";
    }
}
