package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.ZonaDTO;
import com.kusiyyasqa.app.models.mapper.contracts.ZonaMapper;
import com.kusiyyasqa.app.repository.ZonaRepository;
import com.kusiyyasqa.app.service.contracts.ZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZonaServiceImpl implements ZonaService {

    private final ZonaRepository zonaRepository;
    private final ZonaMapper zonaMapper;

    @Autowired
    public ZonaServiceImpl(ZonaRepository zonaRepository, ZonaMapper zonaMapper) {
        this.zonaRepository = zonaRepository;
        this.zonaMapper = zonaMapper;
    }


    @Override
    public List<ZonaDTO> findAll() {
        return this.zonaRepository.findAll()
                .stream()
                .map(this.zonaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ZonaDTO findById(Long id) {
        return this.zonaMapper.toDTO(this.zonaRepository.findById(id).orElse(null));
    }

    @Override
    public ZonaDTO save(ZonaDTO dto) {
        return this.zonaMapper.toDTO(zonaRepository.save(this.zonaMapper.fromDTO(dto)));
    }

    @Override
    public ZonaDTO update(ZonaDTO dto) {
        boolean exists = this.zonaRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.zonaMapper.toDTO(this.zonaRepository.save(this.zonaMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.zonaRepository.existsById(id);
        if(exists){
            this.zonaRepository.deleteById(id);
        }
    }
}
