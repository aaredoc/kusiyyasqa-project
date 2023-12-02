package com.kusiyyasqa.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/anuncio")
public class AnuncioController {

    private final AnuncioService anuncioService;
    
    @Autowired
    public AnuncioController(AnuncioService anuncioService) {
        this.anuncioService = anuncioService;
    }

    @GetMapping
    public List<AnuncioDTO>findAll(){
        return this.anuncioService.findAll();
    }

    @GetMapping("/{id}")
    public AnuncioDTO findById(@PathVariable(value = "id") Long id){
        return this.anuncioService.findById(id);
    }

    @PostMapping
    public AnuncioDTO save(@RequestBody AnuncioDTO anuncioDTO){
        return this.anuncioService.save(anuncioDTO);
    }

    @PutMapping
    public AnuncioDTO update(@RequestBody AnuncioDTO anuncioDTO){
        return this.anuncioService.update(anuncioDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        this.anuncioService.delete(id);
    }
}
