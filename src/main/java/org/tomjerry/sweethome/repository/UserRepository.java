package org.tomjerry.sweethome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tomjerry.sweethome.pojo.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
    UserEntity findByUsernameAndPassword(String username, String password);
    UserEntity findByEmailAndPassword(String email, String password);
    UserEntity findByPhoneAndPassword(String phone, String password);
}