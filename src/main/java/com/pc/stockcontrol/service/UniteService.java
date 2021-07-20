package com.pc.stockcontrol.service;

import com.pc.stockcontrol.entity.Unite;
import com.pc.stockcontrol.repository.UniteRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniteService {

    public UniteRepo uniteRepo;

    public UniteService(UniteRepo uniteRepo) {
        this.uniteRepo = uniteRepo;
    }

    public Optional<Unite> findById(String uniteNo) {
        return uniteRepo.findByUniteNo(uniteNo);
    }

    public List<Unite> findAll() {

        return uniteRepo.findAll();
    }

    public Unite save(Unite unite) {
        return uniteRepo.save(unite);
    }

    public void deleteByUniteNo(String uniteNo) {
        uniteRepo.deleteByUniteNo(uniteNo);
    }
}
