package com.gteam.glog.member.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usr_idx")
    private int idx;

    @Column(name = "usr_id", nullable = false)
    private String userId;


    @Column(name = "usr_tokn", nullable = false)
    private String userToken;
}
