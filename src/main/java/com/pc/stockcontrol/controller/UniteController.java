package com.pc.stockcontrol.controller;

import com.pc.stockcontrol.DTO.UniteDTO;
import com.pc.stockcontrol.Mapper.UniteMapper;
import com.pc.stockcontrol.entity.Unite;
import com.pc.stockcontrol.service.UniteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class UniteController {

    private UniteService uniteService;

    @Autowired
    public UniteController(UniteService unitsService) {
        this.uniteService = unitsService;
    }

    @GetMapping("/unite")
    public List<UniteDTO> getAll() {

        return uniteService.findAll()
                .stream()
                .map(unite -> {
                    System.out.println(unite);
                    return UniteMapper.INSTANCE.toDTO(unite);})
                .collect(Collectors.toList());
    }

    @PostMapping("/unite/post")
    public Unite addRecord(@RequestBody Unite unite) {
        return uniteService.save(unite);
    }

}

