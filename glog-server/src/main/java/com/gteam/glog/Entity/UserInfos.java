package com.gteam.glog.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class UserInfos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_inf_idx")
    private Long idx;

    @OneToOne
    @JoinColumn(name = "usr_idx")
    private Users usr_idx;

    @Column(name = "usr_inf_nm")
    private String username;

    @Column(name = "usr_inf_mail")
    private String useremail;

    @Column(name = "usr_inf_img")
    private String imgPath;

    @Column(name = "usr_inf_glog_titl")
    private String glogTitle;

    @Column(name = "usr_inf_acs")
    private Date userAccessTime;

    @Column(name = "usr_inf_crt")
    private Date userCreateTime;
}
