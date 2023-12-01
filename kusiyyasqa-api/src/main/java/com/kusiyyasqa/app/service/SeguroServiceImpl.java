package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.SeguroDTO;
import com.kusiyyasqa.app.models.mapper.contracts.SeguroMapper;
import com.kusiyyasqa.app.repository.SeguroRepository;
import com.kusiyyasqa.app.service.contracts.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeguroServiceImpl implements SeguroService {

    private final SeguroRepository seguroRepository;
    private final SeguroMapper seguroMapper;

    @Autowired
    public SeguroServiceImpl(SeguroRepository seguroRepository, SeguroMapper seguroMapper) {
        this.seguroRepository = seguroRepository;
        this.seguroMapper = seguroMapper;
    }

    @Override
    public List<SeguroDTO> findAll() {
        return this.seguroRepository.findAll()
                .stream()
                .map(this.seguroMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SeguroDTO findById(Long id) {
        return this.seguroMapper.toDTO(this.seguroRepository.findById(id).orElse(null));
    }

    @Override
    public SeguroDTO save(SeguroDTO dto) {
        return this.seguroMapper.toDTO(seguroRepository.save(this.seguroMapper.fromDTO(dto)));
    }

    @Override
    public SeguroDTO update(SeguroDTO dto) {
        boolean exists = this.seguroRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.seguroMapper.toDTO(this.seguroRepository.save(this.seguroMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.seguroRepository.existsById(id);
        if(exists){
            this.seguroRepository.deleteById(id);
        }
    }
}
