package com.gteam.glog.member.Domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserResponseDTO {
    private int useridx;
    private String userId;
    private String msg;
}
