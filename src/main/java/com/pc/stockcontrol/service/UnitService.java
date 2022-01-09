package com.pc.stockcontrol.service;

import com.pc.stockcontrol.entity.Unite;
import com.pc.stockcontrol.repository.UniteRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService {

    public UniteRepo uniteRepo;

    public UnitService(UniteRepo uniteRepo) {
        this.uniteRepo = uniteRepo;
    }

    public Optional<Unite> findById(String uniteNo) {
        return uniteRepo.findByUniteNo(uniteNo);
    }

    public List<Unite> findAll() {

        return uniteRepo.findAll();
    }

    public void save(Unite unite) {
         uniteRepo.save(unite);
    }

    public void deleteByUniteNo(String uniteNo) {
        uniteRepo.deleteByUniteNo(uniteNo);
    }
}
