package com.pc.stockcontrol.repository;

import com.pc.stockcontrol.entity.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PartRepo extends JpaRepository<Part,Long> {

    @Query ("select p from Part p join FETCH p.bom")
    List<Part> findAllFetchBom();

}
