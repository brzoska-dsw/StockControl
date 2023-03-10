package com.pc.stockcontrol.repository;

import com.pc.stockcontrol.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Long> {

     Optional<User> findByName(String name);
}
