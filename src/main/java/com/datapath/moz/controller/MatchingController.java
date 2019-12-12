package com.datapath.moz.controller;

import com.datapath.moz.dto.NomenclatureDTO;
import com.datapath.moz.service.MatchingWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class MatchingController {

    @Autowired
    private MatchingWebService service;

    @PostMapping("match")
    public List match(@RequestParam("file") MultipartFile file) throws IOException, InterruptedException {
        return service.match(file);
    }

    @PostMapping("save")
    public String save(@RequestBody NomenclatureDTO dto) {
        service.save(dto);
        return "Saved!";
    }

    @GetMapping("get")
    public List get() {
        return service.get();
    }

    @GetMapping("clear")
    public String clear() {
        service.clear();
        return "Cleared!";
    }
}
