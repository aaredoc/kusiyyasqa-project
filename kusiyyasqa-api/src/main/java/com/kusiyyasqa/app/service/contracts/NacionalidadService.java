package com.kusiyyasqa.app.service.contracts;

import com.kusiyyasqa.app.models.dto.NacionalidadDTO;

import java.util.List;

public interface NacionalidadService {
    List<NacionalidadDTO> findAll();
    NacionalidadDTO findById(Long id);
    NacionalidadDTO save(NacionalidadDTO dto);
    NacionalidadDTO update(NacionalidadDTO dto);
    void delete(Long id);
}
