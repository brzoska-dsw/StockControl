package com.pc.stockcontrol.repository;

import com.pc.stockcontrol.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepo extends JpaRepository<Part,Long> {
}
