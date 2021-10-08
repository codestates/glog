package com.gteam.glog.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class UserInfos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_inf_idx")
    private long idx;

    @Column(name = "usr_idx")
    private long usr_idx;

    @Column(name = "usr_inf_nm")
    private String userName;

    @Column(name = "usr_inf_mail")
    private String userMail;

    @Column(name = "usr_inf_img")
    private String userImg;

    @Column(name = "usr_inf_glog_titl")
    private String userGlogTitle;

    @Column(name = "usr_inf_acs")
    private Date userAccesTime;

    @Column(name = "usr_inf_crt")
    private Date userCreateAt;
}
