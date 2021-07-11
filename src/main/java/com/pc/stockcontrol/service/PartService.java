package com.pc.stockcontrol.service;

import com.pc.stockcontrol.entity.Part;
import com.pc.stockcontrol.repository.PartRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PartService {

    private PartRepo partRepo;

    public PartService(PartRepo partRepo) {
        this.partRepo = partRepo;
    }

    public List<Part> findAll(){return partRepo.findAll();}

    public Part save(Part part){
        return partRepo.save(part);
    }

    public Optional<Part> findById(Long id){
        return partRepo.findById(id);
    }

    public void deleteById(long id){
        partRepo.deleteById(id);
    }
}
