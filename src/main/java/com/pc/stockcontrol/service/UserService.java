package com.pc.stockcontrol.service;

import com.pc.stockcontrol.entity.User;
import com.pc.stockcontrol.exceptions.userNotFoundException;
import com.pc.stockcontrol.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Getter
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public User findById(Long id) {
        return getUserRepository()
                .findById(id)
                .orElseThrow(() -> new userNotFoundException("user with id " + id + " not found"));
    }

    public User findByUserName(String name) {
        return userRepository.findByName(name)
                .orElseThrow(() -> new userNotFoundException(name + " not found"));

    }

    public List<User> findAll() {
        return getUserRepository().findAll();
    }

    public ResponseEntity<User> save(User newUser) {

        User user = new User();
        user.setName(newUser.getName());
        user.setSurname(newUser.getName());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setRole(newUser.getRole());
        userRepository.save(user);

        return new ResponseEntity<>(user,
                HttpStatus.CREATED);
    }

    public void deleteById(Long id) {
        getUserRepository().deleteById(id);
    }


}
