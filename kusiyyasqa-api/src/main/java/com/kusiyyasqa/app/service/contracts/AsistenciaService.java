package com.kusiyyasqa.app.service.contracts;

import com.kusiyyasqa.app.models.dto.AsistenciaDTO;

import java.util.List;

public interface AsistenciaService {
    List<AsistenciaDTO> findAll();
    AsistenciaDTO findById(Long id);
    AsistenciaDTO save(AsistenciaDTO dto);
    AsistenciaDTO update(AsistenciaDTO dto);
    void delete(Long id);
}
