package com.kusiyyasqa.app.service.contracts;

import com.kusiyyasqa.app.models.dto.DonativoDTO;

import java.util.List;

public interface DonativoService {
    List<DonativoDTO> findAll();
    DonativoDTO findById(Long id);
    DonativoDTO save(DonativoDTO dto);
    DonativoDTO update(DonativoDTO dto);
    void delete(Long id);
}
