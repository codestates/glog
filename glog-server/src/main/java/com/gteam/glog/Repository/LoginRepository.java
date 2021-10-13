package com.gteam.glog.Repository;

import com.gteam.glog.Domain.UserInfoDTO;
import com.gteam.glog.Entity.Users;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class LoginRepository {
    private final EntityManager entityManager;
    public LoginRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Get User Info by Userid
     *
     * @param id
     * @return UserInfoDTO
     */
    public Optional<UserInfoDTO> getUserInfoByUserId(String id){
        List<UserInfoDTO> userInfoDTO = entityManager
                .createQuery("select usr from UserInfos as usr where usr.usr_idx.userId = ?1", UserInfoDTO.class)
                .setParameter(1,id)
                .getResultList();
        return Optional.ofNullable(userInfoDTO.get(0));
    }

    /**
     * Get Users by Userid
     *
     * @param id
     * @return Users
     */
    public Optional<Users> getUsersByUserId(String id){
        List<Users> users = entityManager
                .createQuery("select usr from Users as usr where usr.userId = ?1", Users.class)
                .setParameter(1,id)
                .getResultList();
        return Optional.ofNullable(users.get(0));
    }
}
