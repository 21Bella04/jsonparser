package com.example.jsonparser.controller;

import com.example.jsonparser.service.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/reddit/")
public class ReditController {

    private final MainService mainService;
    private static int threadNumber = 1;

    public ReditController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("{fileName}")
    public void saveRedit(@PathVariable String fileName) {
        mainService.processFile(fileName, threadNumber);
        threadNumber++;
    }

}
