package com.example.Database.connection.service;

import com.example.Database.connection.exceptions.UserNotFoundException;
import com.example.Database.connection.model.dto.UserDTO;
import com.example.Database.connection.model.entity.User;
import com.example.Database.connection.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //metoda qe kthen te gjitha user-at
    public List<UserDTO> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDTO(user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    //metoda qe kerkon sipas emrit dhe kthen si UserDto
    public List<UserDTO> searchByName(String name){
        return userRepository.findByName(name)
                .stream()
                .map(user -> new UserDTO(user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    //metoda save
    public User save(User user){
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    //metoda per fshirjen sipas ID
    public void deleteUserById(Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException("Perdoruesi me ID " + id +
                    "nuk u gjet");
        }
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User updateUser){
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(updateUser.getName());
                    existingUser.setEmail(updateUser.getEmail());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new UserNotFoundException("Perdoruesi me ID: " + id +
                        "nuk u gjet"));
    }
}
