package com.mruruc.login.service;

import com.mruruc.login.exceptions.UserNotFoundException;
import com.mruruc.login.model.User;
import com.mruruc.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {
    private UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

   // SELECT password,clientId FROM users WHERE userName = ?;

    public Optional<User> getUserByPassword(User user){
        User userByUserName = userRepository.findUserByUserName(user.getUserName());
        if(userByUserName.getPassword().equals(user.getPassword())){
            return Optional.of(userByUserName);
        }
        throw new UserNotFoundException("UserName or Password is incorrect!");
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

}
