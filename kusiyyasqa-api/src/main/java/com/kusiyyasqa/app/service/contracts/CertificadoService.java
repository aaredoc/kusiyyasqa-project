package com.kusiyyasqa.app.service.contracts;

import com.kusiyyasqa.app.models.dto.CertificadoDTO;

import java.util.List;

public interface CertificadoService {
    List<CertificadoDTO> findAll();
    CertificadoDTO findById(Long id);
    CertificadoDTO save(CertificadoDTO dto);
    CertificadoDTO update(CertificadoDTO dto);
    void delete(Long id);
}
