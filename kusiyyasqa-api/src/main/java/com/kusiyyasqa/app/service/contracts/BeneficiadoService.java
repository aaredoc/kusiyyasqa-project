package com.kusiyyasqa.app.service.contracts;

import com.kusiyyasqa.app.models.dto.BeneficiadoDTO;

import java.util.List;

public interface BeneficiadoService {
    List<BeneficiadoDTO> findAll();
    BeneficiadoDTO findById(Long id);
    BeneficiadoDTO save(BeneficiadoDTO dto);
    BeneficiadoDTO update(BeneficiadoDTO dto);
    void delete(Long id);
}
