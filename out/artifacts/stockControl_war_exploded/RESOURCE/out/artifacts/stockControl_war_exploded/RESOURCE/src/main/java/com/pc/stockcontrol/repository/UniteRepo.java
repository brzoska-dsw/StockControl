package com.pc.stockcontrol.repository;

import com.pc.stockcontrol.entity.Unite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UniteRepo extends JpaRepository<Unite, String> {

    Optional<Unite> findByUniteNo(String uniteNo);
    long deleteByUniteNo(String uniteNo);

}
