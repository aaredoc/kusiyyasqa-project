package com.kusiyyasqa.app.service.contracts;

import com.kusiyyasqa.app.models.dto.TurnoDTO;

import java.util.List;

public interface TurnoService {
    List<TurnoDTO> findAll();
    TurnoDTO findById(Long id);
    TurnoDTO save(TurnoDTO dto);
    TurnoDTO update(TurnoDTO dto);
    void delete(Long id);
}
