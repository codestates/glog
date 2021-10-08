package com.gteam.glog.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_idx")
    private long idx;

    @Column(name = "usr_id", nullable = false)
    private String userId;

    @Column(name = "usr_tokn", nullable = false)
    private String userToken;
}
