package com.gteam.glog.Repository;

import com.gteam.glog.Domain.UserInfoDTO;
import com.gteam.glog.Entity.UserInfos;
import com.gteam.glog.Entity.Users;
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

    public boolean DuplicateCheck(String id) {

        UserInfoDTO userInfoDTO = entityManager.find(UserInfoDTO.class, id);

        return userInfoDTO == null;
    }

    public void CreateUserInfo(UserInfoDTO userInfoDTO) {
        if(DuplicateCheck(userInfoDTO.getUserId())) {
            Date now = new Date();
            Users users = new Users();
            UserInfos userInfos = new UserInfos();

            users.setUserId(userInfoDTO.getUserId());
            users.setUserToken(userInfoDTO.getToken());

            userInfos.setUserMail(userInfoDTO.getUserId());
            userInfos.setUserName(userInfoDTO.getUserId());
            userInfos.setUserCreateAt(now);

            entityManager.persist(users);
            entityManager.persist(userInfos);

            entityManager.flush();
            entityManager.close();
        }
    }


}
