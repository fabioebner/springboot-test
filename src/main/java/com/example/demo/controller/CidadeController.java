package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidade")
public class CidadeController {
    @GetMapping("/")
    public List<String> findByNatureza(@RequestParam(name = "q[]") List<String> naturezas){
        return naturezas;
    }
}
