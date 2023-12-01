package com.kusiyyasqa.app.service.contracts;

import com.kusiyyasqa.app.models.dto.SeguroDTO;

import java.util.List;

public interface SeguroService {
    List<SeguroDTO> findAll();
    SeguroDTO findById(Long id);
    SeguroDTO save(SeguroDTO dto);
    SeguroDTO update(SeguroDTO dto);
    void delete(Long id);
}
