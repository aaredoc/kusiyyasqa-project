package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.NacionalidadDTO;
import com.kusiyyasqa.app.models.mapper.contracts.NacionalidadMapper;
import com.kusiyyasqa.app.repository.NacionalidadRepository;
import com.kusiyyasqa.app.service.contracts.NacionalidadService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NacionalidadServiceImpl implements NacionalidadService {

    private final NacionalidadRepository nacionalidadRepository;
    private final NacionalidadMapper nacionalidadMapper;

    public NacionalidadServiceImpl(NacionalidadRepository nacionalidadRepository, NacionalidadMapper nacionalidadMapper) {
        this.nacionalidadRepository = nacionalidadRepository;
        this.nacionalidadMapper = nacionalidadMapper;
    }

    @Override
    public List<NacionalidadDTO> findAll() {
        return this.nacionalidadRepository.findAll()
                .stream()
                .map(this.nacionalidadMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NacionalidadDTO findById(Long id) {
        return this.nacionalidadMapper.toDTO(this.nacionalidadRepository.findById(id).orElse(null));
    }

    @Override
    public NacionalidadDTO save(NacionalidadDTO dto) {
        return this.nacionalidadMapper.toDTO(nacionalidadRepository.save(this.nacionalidadMapper.fromDTO(dto)));
    }

    @Override
    public NacionalidadDTO update(NacionalidadDTO dto) {
        boolean exists = this.nacionalidadRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.nacionalidadMapper.toDTO(this.nacionalidadRepository.save(this.nacionalidadMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.nacionalidadRepository.existsById(id);
        if(exists){
            this.nacionalidadRepository.deleteById(id);
        }
    }
}
