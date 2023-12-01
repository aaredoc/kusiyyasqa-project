package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.AdministradorDTO;

import java.util.List;

public interface AdministradorService {
    List<AdministradorDTO>findAll();
    AdministradorDTO findById(Long id);
    AdministradorDTO save(AdministradorDTO dto);
    AdministradorDTO update(AdministradorDTO dto);
    void delete(Long id);
}
