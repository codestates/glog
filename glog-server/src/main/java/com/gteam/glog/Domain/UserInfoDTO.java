package com.gteam.glog.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoDTO {
    private int userIdx;
    private String userId;
    private String username;
    private String userEmail;
    private String glogTitle;
    private String imgPath;
}
