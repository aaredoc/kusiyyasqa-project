package com.kusiyyasqa.app.service.contracts;

import com.kusiyyasqa.app.models.dto.DocenteDTO;

import java.util.List;

public interface DocenteService {
    List<DocenteDTO> findAll();
    DocenteDTO findById(Long id);
    DocenteDTO save(DocenteDTO dto);
    DocenteDTO update(DocenteDTO dto);
    void delete(Long id);
}
