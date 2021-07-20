package com.pc.stockcontrol.controller;


import com.pc.stockcontrol.entity.Part;
import com.pc.stockcontrol.service.PartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/part")
@CrossOrigin(origins = "http://localhost:8080")
public class PartController {

    private PartService partService;

    @PostMapping("/post")
    public Part addRecord(@RequestBody Part part) {
        return partService.save(part);
    }

}
