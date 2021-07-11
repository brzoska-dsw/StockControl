package com.pc.stockcontrol.controller;

import com.pc.stockcontrol.entity.Unite;
import com.pc.stockcontrol.service.UniteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class UniteController {

    private UniteService uniteService;

    @Autowired
    public UniteController(UniteService unitsService) {
        this.uniteService = unitsService;
    }

    @GetMapping("/all")
    public List<Unite> getAll() {
        return uniteService.findAll();
    }

    @PostMapping("/post")
    public Unite addRecord(@RequestBody Unite unite) {
        return uniteService.save(unite);
    }

}

