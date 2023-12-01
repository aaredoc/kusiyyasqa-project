package com.kusiyyasqa.app.service.contracts;

import com.kusiyyasqa.app.models.dto.ParticipacionDTO;

import java.util.List;

public interface ParticipacionService {
    List<ParticipacionDTO> findAll();
    ParticipacionDTO findById(Long id);
    ParticipacionDTO save(ParticipacionDTO dto);
    ParticipacionDTO update(ParticipacionDTO dto);
    void delete(Long id);
}
