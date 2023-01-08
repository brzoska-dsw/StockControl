package com.pc.stockcontrol.controller;

import com.pc.stockcontrol.entity.Bom;
import com.pc.stockcontrol.entity.Part;
import com.pc.stockcontrol.service.BomService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
public class BomController {

    private BomService bomService;

    @GetMapping("/bom")
    public List<Bom> findAll(){
        return bomService.findAll();
//        return bomService.BomService();
    }

}
