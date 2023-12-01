package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.VoluntarioDTO;
import com.kusiyyasqa.app.models.mapper.contracts.VoluntarioMapper;
import com.kusiyyasqa.app.repository.VoluntarioRepository;
import com.kusiyyasqa.app.service.contracts.VoluntarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoluntarioServiceImpl implements VoluntarioService {

    private final VoluntarioRepository voluntarioRepository;
    private final VoluntarioMapper voluntarioMapper;

    @Autowired
    public VoluntarioServiceImpl(VoluntarioRepository voluntarioRepository, VoluntarioMapper voluntarioMapper) {
        this.voluntarioRepository = voluntarioRepository;
        this.voluntarioMapper = voluntarioMapper;
    }

    @Override
    public List<VoluntarioDTO> findAll() {
        return this.voluntarioRepository.findAll()
                .stream()
                .map(this.voluntarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VoluntarioDTO findById(Long id) {
        return this.voluntarioMapper.toDTO(this.voluntarioRepository.findById(id).orElse(null));

    }

    @Override
    public VoluntarioDTO save(VoluntarioDTO dto) {
        return this.voluntarioMapper.toDTO(voluntarioRepository.save(this.voluntarioMapper.fromDTO(dto)));
    }

    @Override
    public VoluntarioDTO update(VoluntarioDTO dto) {
        boolean exists = this.voluntarioRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.voluntarioMapper.toDTO(this.voluntarioRepository.save(this.voluntarioMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.voluntarioRepository.existsById(id);
        if(exists){
            this.voluntarioRepository.deleteById(id);
        }
    }
}
