package com.pc.stockcontrol.controller;


import com.pc.stockcontrol.DTO.DisplayPartDTO;
import com.pc.stockcontrol.entity.Part;
import com.pc.stockcontrol.service.PartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin
@AllArgsConstructor
public class PartController {

    private final PartService partService;

    @GetMapping("/part/all")
    public List<Part> findAllFetchBom(){

        return partService.findAllFetchBom();
    }

    @GetMapping("/part")
    public List<Part> findAll(){

        return partService.findAll();
    }

    @PostMapping("/part/post")
    public Part addRecord(@RequestBody Part part) {

        return partService.save(part);
    }

    @DeleteMapping("/part/delete/{id}")
    public void deleteRecord (@PathVariable String id){
        partService.deleteById(id);
    }

    @PutMapping("/part/update")
    public Part updateRecord(@RequestBody Part part) {

        return partService.save(part);
    }

    @GetMapping("/display")
    public List<DisplayPartDTO> findAllPartsUnitsData(){

        return partService.findAllPartsUnitsData();
    }

}
