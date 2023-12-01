package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.AdministradorDTO;
import com.kusiyyasqa.app.models.mapper.contracts.AdministradorMapper;
import com.kusiyyasqa.app.repository.AdministradorRepository;
import com.kusiyyasqa.app.service.contracts.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministradorServiceImpl implements AdministradorService {

    private final AdministradorRepository administradorRepository;
    private final AdministradorMapper administradorMapper;

    @Autowired
    public AdministradorServiceImpl(AdministradorRepository administradorRepository, AdministradorMapper administradorMapper){
        this.administradorRepository = administradorRepository;
        this.administradorMapper = administradorMapper;
    }

    @Override
    public List<AdministradorDTO> findAll() {
        return this.administradorRepository.findAll()
                .stream()
                .map(this.administradorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AdministradorDTO findById(Long id) {
        return this.administradorMapper.toDTO(this.administradorRepository.findById(id).orElse(null));
    }

    @Override
    public AdministradorDTO save(AdministradorDTO dto) {
        return this.administradorMapper.toDTO(administradorRepository.save(this.administradorMapper.fromDTO(dto)));
    }

    @Override
    public AdministradorDTO update(AdministradorDTO dto) {
        boolean exists = this.administradorRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.administradorMapper.toDTO(this.administradorRepository.save(this.administradorMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.administradorRepository.existsById(id);
        if(exists){
           this.administradorRepository.deleteById(id);
        }
    }
}
