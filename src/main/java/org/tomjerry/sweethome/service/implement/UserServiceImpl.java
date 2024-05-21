package org.tomjerry.sweethome.service.implement;

import org.springframework.stereotype.Service;
import org.tomjerry.sweethome.dao.implement.UserDaoImpl;
import org.tomjerry.sweethome.pojo.entity.UserEntity;
import org.tomjerry.sweethome.repository.UserRepository;
import org.tomjerry.sweethome.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(UserEntity user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserEntity getUserById(int id) {
        UserEntity userEntity = userRepository.findById(id).orElse(null);
        return userEntity;
    }
}
