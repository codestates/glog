package com.gteam.glog.Entity;

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
    private Long idx;

    @Column(name = "usr_id", nullable = false)
    private String userId;

    @Column(name = "usr_token", nullable = false)
    private String userToken;
}
