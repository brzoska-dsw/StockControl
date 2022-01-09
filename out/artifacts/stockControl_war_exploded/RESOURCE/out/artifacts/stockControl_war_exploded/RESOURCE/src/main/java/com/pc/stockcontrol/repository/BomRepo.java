package com.pc.stockcontrol.repository;

import com.pc.stockcontrol.entity.Bom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BomRepo extends JpaRepository<Bom, Long> {
}
