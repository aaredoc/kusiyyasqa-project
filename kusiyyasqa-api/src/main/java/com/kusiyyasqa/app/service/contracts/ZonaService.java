package com.kusiyyasqa.app.service.contracts;

import com.kusiyyasqa.app.models.dto.ZonaDTO;

import java.util.List;

public interface ZonaService {
    List<ZonaDTO> findAll();
    ZonaDTO findById(Long id);
    ZonaDTO save(ZonaDTO dto);
    ZonaDTO update(ZonaDTO dto);
    void delete(Long id);
}
