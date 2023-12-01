package com.kusiyyasqa.app.service.contracts;

import com.kusiyyasqa.app.models.dto.ParentescoDTO;

import java.util.List;

public interface ParentescoService {
    List<ParentescoDTO> findAll();
    ParentescoDTO findById(Long id);
    ParentescoDTO save(ParentescoDTO dto);
    ParentescoDTO update(ParentescoDTO dto);
    void delete(Long id);
}
