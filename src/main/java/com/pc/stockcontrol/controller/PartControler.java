package com.pc.stockcontrol.controller;

import com.pc.stockcontrol.entity.Part;
import com.pc.stockcontrol.service.PartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/apii")
public class PartControler {

    private PartService partService;

    @PostMapping("post")
    public Part addRecord(@RequestBody Part part) {
        return partService.save(part);
    }

}
