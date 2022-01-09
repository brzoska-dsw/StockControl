package com.pc.stockcontrol.controller;


import com.pc.stockcontrol.DTO.DisplayPartDTO;
import com.pc.stockcontrol.entity.Part;
import com.pc.stockcontrol.service.PartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
@AllArgsConstructor
public class PartController {

    private final PartService partService;

    @GetMapping("/part")
    public List<Part> findAll(){

        return partService.findAllFetchBom();
    }

    @PostMapping("/part/post")
    public Part addRecord(@RequestBody Part part) {

        return partService.save(part);
    }

    @GetMapping("/display")
    public List<DisplayPartDTO> findAllPartsUnitsData(){

        return partService.findAllPartsUnitsData();
    }

}
