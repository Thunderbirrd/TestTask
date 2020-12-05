package com.example.test.services;

import com.example.test.models.User;
import com.example.test.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Сервис - подушка между репозиторием и контроллером

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Transactional(readOnly = true)
    public User getUser(Integer id){
        return userRepo.findById(id).orElse(null);
    }

    @Transactional
    public User saveUser(User user){
        userRepo.save(user);
        return userRepo.findById(user.getId()).orElse(null);
    }

    @Transactional
    public boolean deleteUser(User user){
        if(user != null) {
            userRepo.delete(user);
            return true;
        }else{
            return false;
        }
    }

    @Transactional
    public User findUserByLogin(String login){
        return userRepo.findUserByLogin(login);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers(){
        return userRepo.getAllUsers();
    }
}
