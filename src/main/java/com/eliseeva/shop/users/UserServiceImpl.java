package com.eliseeva.shop.users;

import com.eliseeva.shop.rest.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){ this.userRepository = userRepository; }

    @Override
    public UserEntity addUser(User user){
        if(!userRepository.existsByNumber(user.getNumber())){
            UserEntity userEntity = new UserEntity();
            userEntity.setName(user.getName());
            userEntity.setNumber(user.getNumber());
            userRepository.saveAndFlush(userEntity);
        }
        return userRepository.findUserEntityByNumber(user.getNumber());
    }
}
