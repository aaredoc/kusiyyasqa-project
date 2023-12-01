package com.kusiyyasqa.app.service.contracts;

import com.kusiyyasqa.app.models.dto.ClaseDTO;

import java.util.List;

public interface ClaseService {
    List<ClaseDTO> findAll();
    ClaseDTO findById(Long id);
    ClaseDTO save(ClaseDTO dto);
    ClaseDTO update(ClaseDTO dto);
    void delete(Long id);
}
