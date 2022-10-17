package com.example.liashenkospring.service;

import com.example.liashenkospring.entity.UserEntity;
import com.example.liashenkospring.exception.UserAlreadyExistsException;
import com.example.liashenkospring.exception.UserNotFoundException;
import com.example.liashenkospring.model.User;
import com.example.liashenkospring.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistsException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw  new UserAlreadyExistsException("A user with that name exists!!!");
        }
        return userRepo.save(user);
    }

    public com.example.liashenkospring.model.User getOne(Long id) throws UserNotFoundException {
        UserEntity userEntity = userRepo.findById(id).get();
        if (userEntity == null) {
            throw new UserNotFoundException("User not found!!!");
        }
        return com.example.liashenkospring.model.User.toModel(userEntity);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
