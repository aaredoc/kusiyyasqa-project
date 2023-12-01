package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.TurnoDTO;
import com.kusiyyasqa.app.models.mapper.contracts.TurnoMapper;
import com.kusiyyasqa.app.repository.TurnoRepository;
import com.kusiyyasqa.app.service.contracts.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurnoServiceImpl implements TurnoService {

    private final TurnoRepository turnoRepository;
    private final TurnoMapper turnoMapper;

    @Autowired
    public TurnoServiceImpl(TurnoRepository turnoRepository, TurnoMapper turnoMapper) {
        this.turnoRepository = turnoRepository;
        this.turnoMapper = turnoMapper;
    }

    @Override
    public List<TurnoDTO> findAll() {
        return this.turnoRepository.findAll()
                .stream()
                .map(this.turnoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TurnoDTO findById(Long id) {
        return this.turnoMapper.toDTO(this.turnoRepository.findById(id).orElse(null));
    }

    @Override
    public TurnoDTO save(TurnoDTO dto) {
        return this.turnoMapper.toDTO(turnoRepository.save(this.turnoMapper.fromDTO(dto)));
    }

    @Override
    public TurnoDTO update(TurnoDTO dto) {
        boolean exists = this.turnoRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.turnoMapper.toDTO(this.turnoRepository.save(this.turnoMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.turnoRepository.existsById(id);
        if(exists){
            this.turnoRepository.deleteById(id);
        }
    }
}
