package org.tomjerry.sweethome.util.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.tomjerry.sweethome.pojo.entity.UserEntity;
import org.tomjerry.sweethome.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        UserEntity user = userRepository.findById(Integer.parseInt(id)).orElse(null);
        if(user == null){
            throw new UsernameNotFoundException("User not found:" + id);
        }

        return new CustomUserDetails(user);
    }
}
