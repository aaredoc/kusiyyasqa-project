package com.kusiyyasqa.app.service.contracts;

import com.kusiyyasqa.app.models.dto.SectorDTO;

import java.util.List;

public interface SectorService {
    List<SectorDTO> findAll();
    SectorDTO findById(Long id);
    SectorDTO save(SectorDTO dto);
    SectorDTO update(SectorDTO dto);
    void delete(Long id);
}
