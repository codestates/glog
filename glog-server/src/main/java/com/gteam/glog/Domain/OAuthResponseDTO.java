package com.gteam.glog.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OAuthResponseDTO {
    private String access_token;
    private String scope;
    private String token_type;
}
