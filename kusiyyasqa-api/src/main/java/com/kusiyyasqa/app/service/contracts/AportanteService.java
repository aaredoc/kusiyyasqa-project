package com.kusiyyasqa.app.service.contracts;

import com.kusiyyasqa.app.models.dto.AportanteDTO;

import java.util.List;

public interface AportanteService {
    List<AportanteDTO> findAll();
    AportanteDTO findById(Long id);
    AportanteDTO save(AportanteDTO dto);
    AportanteDTO update(AportanteDTO dto);
    void delete(Long id);
}
