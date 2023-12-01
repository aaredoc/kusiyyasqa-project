package com.kusiyyasqa.app.service.contracts;

import com.kusiyyasqa.app.models.dto.AnuncioDTO;

import java.util.List;

public interface AnuncioService {
    List<AnuncioDTO> findAll();
    AnuncioDTO findById(Long id);
    AnuncioDTO save(AnuncioDTO dto);
    AnuncioDTO update(AnuncioDTO dto);
    void delete(Long id);
}
