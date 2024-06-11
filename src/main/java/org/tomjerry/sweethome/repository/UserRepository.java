package org.tomjerry.sweethome.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.tomjerry.sweethome.pojo.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByUsername(String username);
    UserEntity findByUsernameAndPassword(String username, String password);
    UserEntity findByEmailAndPassword(String email, String password);
    UserEntity findByPhoneAndPassword(String phone, String password);
    UserEntity findByEmail(String email);

    @Query("SELECT u FROM UserEntity u WHERE " +
            "u.username LIKE %:keyword% " +
            "ORDER BY CASE WHEN u.username LIKE %:keyword% THEN 1 ELSE 2 END")
    Page<UserEntity> searchUser(@Param("keyword") String keyword, Pageable pageable);

    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}