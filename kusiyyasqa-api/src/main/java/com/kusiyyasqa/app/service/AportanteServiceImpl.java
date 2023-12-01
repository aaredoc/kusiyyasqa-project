package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.AportanteDTO;
import com.kusiyyasqa.app.models.mapper.contracts.AportanteMapper;

import com.kusiyyasqa.app.repository.AportanteRepository;
import com.kusiyyasqa.app.service.contracts.AportanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AportanteServiceImpl implements AportanteService {

    private final AportanteRepository aportanteRepository;
    private final AportanteMapper aportanteMapper;

    @Autowired
    public AportanteServiceImpl(AportanteRepository aportanteRepository, AportanteMapper aportanteMapper){
        this.aportanteRepository = aportanteRepository;
        this.aportanteMapper = aportanteMapper;
    }

    @Override
    public List<AportanteDTO> findAll() {
        return this.aportanteRepository.findAll()
                .stream()
                .map(this.aportanteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AportanteDTO findById(Long id) {
        return this.aportanteMapper.toDTO(this.aportanteRepository.findById(id).orElse(null));

    }

    @Override
    public AportanteDTO save(AportanteDTO dto) {
        return this.aportanteMapper.toDTO(aportanteRepository.save(this.aportanteMapper.fromDTO(dto)));

    }

    @Override
    public AportanteDTO update(AportanteDTO dto) {
        boolean exists = this.aportanteRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.aportanteMapper.toDTO(this.aportanteRepository.save(this.aportanteMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.aportanteRepository.existsById(id);
        if(exists){
            this.aportanteRepository.deleteById(id);
        }
    }
}
