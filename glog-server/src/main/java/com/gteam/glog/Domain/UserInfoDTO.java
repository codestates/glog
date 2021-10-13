package com.gteam.glog.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDTO {
    private int userIdx;
    private String usertoken;
    private String userId;
    private String userName;
    private String userEmail;
    private String glogTitle;
    private String imgPath;
}
