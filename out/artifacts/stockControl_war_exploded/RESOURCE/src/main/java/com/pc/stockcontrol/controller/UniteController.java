package com.pc.stockcontrol.controller;

import com.pc.stockcontrol.DTO.UnitDTO;
import com.pc.stockcontrol.Mapper.UniteMapper;
import com.pc.stockcontrol.entity.Unite;
import com.pc.stockcontrol.repository.UniteRepo;
import com.pc.stockcontrol.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class UniteController {

    private final UnitService unitService;

    @Autowired
    public UniteController(UnitService unitsService) {
        this.unitService = unitsService;
    }

    @GetMapping("/unite")
    public List<UnitDTO> getAll() {

        return unitService.findAll()
                .stream()
                .map(unite -> UniteMapper.INSTANCE.toDTO(unite))
                .collect(Collectors.toList());
    }

    @PostMapping("/unite/post")
    public void  addRecord(@RequestBody final Unite unite) {
         unitService.save(unite);

    }

}

