package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.DocenteDTO;
import com.kusiyyasqa.app.models.mapper.contracts.DocenteMapper;
import com.kusiyyasqa.app.repository.DocenteRepository;
import com.kusiyyasqa.app.service.contracts.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocenteServiceImpl implements DocenteService {

    private final DocenteRepository docenteRepository;
    private final DocenteMapper docenteMapper;

    @Autowired
    public DocenteServiceImpl(DocenteRepository docenteRepository, DocenteMapper docenteMapper) {
        this.docenteRepository = docenteRepository;
        this.docenteMapper = docenteMapper;
    }

    @Override
    public List<DocenteDTO> findAll() {
        return this.docenteRepository.findAll()
                .stream()
                .map(this.docenteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DocenteDTO findById(Long id) {
        return this.docenteMapper.toDTO(this.docenteRepository.findById(id).orElse(null));
    }

    @Override
    public DocenteDTO save(DocenteDTO dto) {
        return this.docenteMapper.toDTO(docenteRepository.save(this.docenteMapper.fromDTO(dto)));
    }

    @Override
    public DocenteDTO update(DocenteDTO dto) {
        boolean exists = this.docenteRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.docenteMapper.toDTO(this.docenteRepository.save(this.docenteMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.docenteRepository.existsById(id);
        if(exists){
            this.docenteRepository.deleteById(id);
        }
    }
}
