package org.tomjerry.sweethome.util.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.tomjerry.sweethome.pojo.entity.UserEntity;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final UserEntity userEntity;

    public CustomUserDetails(UserEntity userEntity) {
        this.userEntity = userEntity;
    }



    /*
    * getAuthorities() method is used to get the authorities of the user.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        String role = userEntity.getIsAdmin() == 1 ? "ROLE_ADMIN" : "ROLE_USER";

        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }



    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userEntity.getStatus() == 1;
    }
}
