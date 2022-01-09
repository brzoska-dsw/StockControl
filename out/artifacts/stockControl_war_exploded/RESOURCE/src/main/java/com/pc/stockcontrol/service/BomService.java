package com.pc.stockcontrol.service;


import com.pc.stockcontrol.entity.Bom;
import com.pc.stockcontrol.repository.BomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BomService {

    private BomRepo bomRepo;

    public BomService(BomRepo bomRepo) {
        this.bomRepo = bomRepo;
    }

    public Optional<Bom> findById(Long id) {
        return bomRepo.findById(id);
    }

    public List<Bom> findAll() {
        return bomRepo.findAll();
    }

    public Bom save(Bom bom) {
        return bomRepo.save(bom);
    }

    public void deleteById(Long id) {
        bomRepo.deleteById(id);
    }

}
