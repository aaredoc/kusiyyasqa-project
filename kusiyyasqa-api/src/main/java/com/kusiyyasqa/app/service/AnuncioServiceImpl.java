package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.AnuncioDTO;
import com.kusiyyasqa.app.models.mapper.contracts.AnuncioMapper;
import com.kusiyyasqa.app.repository.AnuncioRepository;
import com.kusiyyasqa.app.service.contracts.AnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnuncioServiceImpl implements AnuncioService {


    private final AnuncioRepository anuncioRepository;
    private final AnuncioMapper anuncioMapper;

    @Autowired
    public AnuncioServiceImpl(AnuncioRepository anuncioRepository, AnuncioMapper anuncioMapper) {
        this.anuncioRepository = anuncioRepository;
        this.anuncioMapper = anuncioMapper;
    }

    @Override
    public List<AnuncioDTO> findAll() {
        return this.anuncioRepository.findAll()
                .stream()
                .map(this.anuncioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AnuncioDTO findById(Long id) {
        return this.anuncioMapper.toDTO(this.anuncioRepository.findById(id).orElse(null));
    }

    @Override
    public AnuncioDTO save(AnuncioDTO dto) {
        return this.anuncioMapper.toDTO(this.anuncioRepository.save(this.anuncioMapper.fromDTO(dto)));
    }

    @Override
    public AnuncioDTO update(AnuncioDTO dto) {
        boolean exists = this.anuncioRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.anuncioMapper.toDTO(this.anuncioRepository.save(this.anuncioMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.anuncioRepository.existsById(id);
        if(exists){
            this.anuncioRepository.deleteById(id);
        }
    }
}
