package com.gteam.glog.Service;

import com.gteam.glog.Domain.OAuthResponseDTO;
import com.gteam.glog.Entity.OAuthCode;
import com.gteam.glog.Repository.OAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class OAuthService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final OAuthRepository oAuthRepository;

    @Autowired
    public OAuthService(OAuthRepository oAuthRepository) {
        this.oAuthRepository = oAuthRepository;
    }


    public Optional<OAuthResponseDTO> validateOAuthLogin(){
        OAuthCode oAuthCode = oAuthRepository.FindUserOAuthCode();

        // send data id, secret key , ...
        OAuthResponseDTO token = restTemplate.postForObject(
                "https://github.com/login/oauth/access_token",
                null, // {요청할 때 보낼 데이터}
                OAuthResponseDTO.class);
        if(token != null){
            return Optional.ofNullable(token);
        }else{
            return Optional.empty();
        }
    }

}
