package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.ParentescoDTO;
import com.kusiyyasqa.app.models.mapper.contracts.ParentescoMapper;
import com.kusiyyasqa.app.repository.ParentescoRepository;
import com.kusiyyasqa.app.service.contracts.ParentescoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParentescoServiceImpl implements ParentescoService {

    private final ParentescoRepository parentescoRepository;
    private final ParentescoMapper parentescoMapper;

    @Autowired
    public ParentescoServiceImpl(ParentescoRepository parentescoRepository, ParentescoMapper parentescoMapper) {
        this.parentescoRepository = parentescoRepository;
        this.parentescoMapper = parentescoMapper;
    }

    @Override
    public List<ParentescoDTO> findAll() {
        return this.parentescoRepository.findAll()
                .stream()
                .map(this.parentescoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParentescoDTO findById(Long id) {
        return this.parentescoMapper.toDTO(this.parentescoRepository.findById(id).orElse(null));

    }

    @Override
    public ParentescoDTO save(ParentescoDTO dto) {
        return this.parentescoMapper.toDTO(parentescoRepository.save(this.parentescoMapper.fromDTO(dto)));
    }

    @Override
    public ParentescoDTO update(ParentescoDTO dto) {
        boolean exists = this.parentescoRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.parentescoMapper.toDTO(this.parentescoRepository.save(this.parentescoMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.parentescoRepository.existsById(id);
        if(exists){
            this.parentescoRepository.deleteById(id);
        }
    }
}
