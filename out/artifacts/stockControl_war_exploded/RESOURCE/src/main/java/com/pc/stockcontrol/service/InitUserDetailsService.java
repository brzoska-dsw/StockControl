package com.pc.stockcontrol.service;

import com.pc.stockcontrol.exceptions.UserNotFoundException;
import com.pc.stockcontrol.repository.UserRepo;
import com.pc.stockcontrol.utility.UserDetailsAdapter;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class InitUserDetailsService implements UserDetailsService {

    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UserNotFoundException {
        return userRepo.findByName(name)
                .map(UserDetailsAdapter::new)
                .orElseThrow(() -> new UserNotFoundException(name + " not found"));
    }
}
