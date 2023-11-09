package com.mywellbeing.user.service;


import com.mywellbeing.user.dto.UserDTO;
import com.mywellbeing.user.entity.User;
import com.mywellbeing.user.exceptions.UserNotFoundException;
import com.mywellbeing.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository repository;


    public User createUser(UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setDocument(userDTO.getDocument());
        user.setTelephone(userDTO.getTelephone());
        user.setStatus(userDTO.getStatus());
        user.setGender(userDTO.getGender());
        user.setAge(userDTO.getAge());
        user.setHomeRole(userDTO.getHomeRole());
        user.setWorking(userDTO.getWorking());
        user.setHasChildren(userDTO.getHasChildren());
        user.setCity(userDTO.getCity());
        user.setSocialCategory(userDTO.getSocialCategory());
        return repository.save(user);
    }

    public List<User> getAll(){
        return repository.findAll();
    }

    public Optional<User> getOne(Long id){
        return Optional.of(repository.findById(id))
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    public Optional<User> update(UserDTO userDTO, Long id){
        return Optional.ofNullable(repository.findById(id)
                .map(user -> {
                    user.setName(userDTO.getName());
                    user.setDocument(userDTO.getDocument());
                    user.setTelephone(userDTO.getTelephone());
                    user.setStatus(userDTO.getStatus());
                    user.setGender(userDTO.getGender());
                    user.setAge(userDTO.getAge());
                    user.setHomeRole(userDTO.getHomeRole());
                    user.setWorking(userDTO.getWorking());
                    user.setHasChildren(userDTO.getHasChildren());
                    user.setCity(userDTO.getCity());
                    user.setSocialCategory(userDTO.getSocialCategory());
                    return repository.save(user);
                }).orElseThrow(()->new UserNotFoundException(id)));
    }

    public Boolean delete(Long id){
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            return true;
        }else{
            return false;

        }
    }

}
