package com.kusiyyasqa.app.service.contracts;

import com.kusiyyasqa.app.models.dto.VoluntarioDTO;

import java.util.List;

public interface VoluntarioService {
    List<VoluntarioDTO> findAll();
    VoluntarioDTO findById(Long id);
    VoluntarioDTO save(VoluntarioDTO dto);
    VoluntarioDTO update(VoluntarioDTO dto);
    void delete(Long id);
}
