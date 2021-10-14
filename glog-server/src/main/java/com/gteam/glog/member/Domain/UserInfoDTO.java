package com.gteam.glog.member.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDTO {
    private int userIdx;
    private String userToken;
    private String userId;
    private String userName;
    private String userEmail;
    private String glogTitle;
    private String imgPath;
}
