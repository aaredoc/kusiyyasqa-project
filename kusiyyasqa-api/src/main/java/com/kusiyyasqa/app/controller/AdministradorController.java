package com.kusiyyasqa.app.controller;

import com.kusiyyasqa.app.models.dto.AdministradorDTO;
import com.kusiyyasqa.app.service.contracts.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/administrador")
public class AdministradorController {

    
    private final AdministradorService administradorService;
    
    @Autowired
    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping
    public List<AdministradorDTO>findAll(){
        return this.administradorService.findAll();
    }

    @GetMapping("/{id}")
    public AdministradorDTO findById(@PathVariable(value = "id")Long id){
        return this.administradorService.findById(id);
    }

    @PostMapping
    public AdministradorDTO save(@RequestBody AdministradorDTO administradorDTO){
        return this.administradorService.save(administradorDTO);
    }

    @PutMapping
    public AdministradorDTO update(@RequestBody AdministradorDTO administradorDTO){
        return this.administradorService.update(administradorDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        this.administradorService.delete(id);
    }
}
