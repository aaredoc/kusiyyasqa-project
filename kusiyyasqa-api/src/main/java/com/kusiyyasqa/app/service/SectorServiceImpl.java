package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.SectorDTO;
import com.kusiyyasqa.app.models.mapper.contracts.SectorMapper;
import com.kusiyyasqa.app.repository.SectorRepository;
import com.kusiyyasqa.app.service.contracts.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SectorServiceImpl implements SectorService {

    private final SectorRepository sectorRepository;
    private final SectorMapper sectorMapper;

    @Autowired
    public SectorServiceImpl(SectorRepository sectorRepository, SectorMapper sectorMapper) {
        this.sectorRepository = sectorRepository;
        this.sectorMapper = sectorMapper;
    }

    @Override
    public List<SectorDTO> findAll() {
        return this.sectorRepository.findAll()
                .stream()
                .map(this.sectorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SectorDTO findById(Long id) {
        return this.sectorMapper.toDTO(this.sectorRepository.findById(id).orElse(null));
    }

    @Override
    public SectorDTO save(SectorDTO dto) {
        return this.sectorMapper.toDTO(sectorRepository.save(this.sectorMapper.fromDTO(dto)));
    }

    @Override
    public SectorDTO update(SectorDTO dto) {
        boolean exists = this.sectorRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.sectorMapper.toDTO(this.sectorRepository.save(this.sectorMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.sectorRepository.existsById(id);
        if(exists){
            this.sectorRepository.deleteById(id);
        }
    }
}
