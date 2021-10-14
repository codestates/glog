package com.gteam.glog.register.Repository;

import com.gteam.glog.member.Domain.UserInfoDTO;
import com.gteam.glog.member.Entity.UserInfos;
import com.gteam.glog.member.Entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;

@Repository
@Transactional
public class RegisterRepository {

    private final EntityManager entityManager;

    @Autowired
    public RegisterRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean duplicateCheck(String id) {
        UserInfoDTO userInfoDTO = entityManager.find(UserInfoDTO.class, id);
        return userInfoDTO == null;
    }
    public void createUserInfo(UserInfoDTO userInfoDTO) {
        if(duplicateCheck(userInfoDTO.getUserId())) {
            Date now = new Date();
            Users users = new Users();
            UserInfos userInfos = new UserInfos();

            users.setUserId(userInfoDTO.getUserId());
            users.setUserToken(userInfoDTO.getUserToken());

            userInfos.setUseremail(userInfoDTO.getUserId());
            userInfos.setUsername(userInfoDTO.getUserName());
            userInfos.setUserCreateTime(now);

            entityManager.persist(users);
            entityManager.persist(userInfos);

            entityManager.flush();
            entityManager.close();
        }
    }
}
