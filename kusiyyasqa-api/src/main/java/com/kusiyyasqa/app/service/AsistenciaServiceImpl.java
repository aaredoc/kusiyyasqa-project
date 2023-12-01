package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.AsistenciaDTO;
import com.kusiyyasqa.app.models.mapper.contracts.AsistenciaMapper;
import com.kusiyyasqa.app.repository.AsistenciaRepository;
import com.kusiyyasqa.app.service.contracts.AsistenciaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AsistenciaServiceImpl implements AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;
    private final AsistenciaMapper asistenciaMapper;

    public AsistenciaServiceImpl(AsistenciaRepository asistenciaRepository, AsistenciaMapper asistenciaMapper) {
        this.asistenciaRepository = asistenciaRepository;
        this.asistenciaMapper = asistenciaMapper;
    }


    @Override
    public List<AsistenciaDTO> findAll() {
        return this.asistenciaRepository.findAll()
                .stream()
                .map(this.asistenciaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AsistenciaDTO findById(Long id) {
        return this.asistenciaMapper.toDTO(this.asistenciaRepository.findById(id).orElse(null));

    }

    @Override
    public AsistenciaDTO save(AsistenciaDTO dto) {
        return this.asistenciaMapper.toDTO(asistenciaRepository.save(this.asistenciaMapper.fromDTO(dto)));

    }

    @Override
    public AsistenciaDTO update(AsistenciaDTO dto) {
        boolean exists = this.asistenciaRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.asistenciaMapper.toDTO(this.asistenciaRepository.save(this.asistenciaMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.asistenciaRepository.existsById(id);
        if(exists){
            this.asistenciaRepository.deleteById(id);
        }
    }
}
