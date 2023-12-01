package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.DonativoDTO;
import com.kusiyyasqa.app.models.mapper.contracts.DonativoMapper;
import com.kusiyyasqa.app.repository.DonativoRepository;
import com.kusiyyasqa.app.service.contracts.DonativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DonativoServiceImpl implements DonativoService {

    private final DonativoRepository donativoRepository;
    private final DonativoMapper donativoMapper;

    @Autowired
    public DonativoServiceImpl(DonativoRepository donativoRepository, DonativoMapper donativoMapper) {
        this.donativoRepository = donativoRepository;
        this.donativoMapper = donativoMapper;
    }

    @Override
    public List<DonativoDTO> findAll() {
        return this.donativoRepository.findAll()
                .stream()
                .map(this.donativoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DonativoDTO findById(Long id) {
        return this.donativoMapper.toDTO(this.donativoRepository.findById(id).orElse(null));
    }

    @Override
    public DonativoDTO save(DonativoDTO dto) {
        return this.donativoMapper.toDTO(donativoRepository.save(this.donativoMapper.fromDTO(dto)));
    }

    @Override
    public DonativoDTO update(DonativoDTO dto) {
        boolean exists = this.donativoRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.donativoMapper.toDTO(this.donativoRepository.save(this.donativoMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.donativoRepository.existsById(id);
        if(exists){
            this.donativoRepository.deleteById(id);
        }
    }
}
