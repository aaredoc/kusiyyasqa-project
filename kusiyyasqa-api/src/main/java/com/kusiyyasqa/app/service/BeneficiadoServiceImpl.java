package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.BeneficiadoDTO;
import com.kusiyyasqa.app.models.mapper.contracts.BeneficiadoMapper;
import com.kusiyyasqa.app.repository.BeneficiadoRepository;
import com.kusiyyasqa.app.service.contracts.BeneficiadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeneficiadoServiceImpl implements BeneficiadoService {

    private final BeneficiadoRepository beneficiadoRepository;
    private final BeneficiadoMapper beneficiadoMapper;

    public BeneficiadoServiceImpl(BeneficiadoRepository beneficiadoRepository, BeneficiadoMapper beneficiadoMapper) {
        this.beneficiadoRepository = beneficiadoRepository;
        this.beneficiadoMapper = beneficiadoMapper;
    }


    @Override
    public List<BeneficiadoDTO> findAll() {
        return this.beneficiadoRepository.findAll()
                .stream()
                .map(this.beneficiadoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BeneficiadoDTO findById(Long id) {
        return this.beneficiadoMapper.toDTO(this.beneficiadoRepository.findById(id).orElse(null));
    }

    @Override
    public BeneficiadoDTO save(BeneficiadoDTO dto) {
        return this.beneficiadoMapper.toDTO(beneficiadoRepository.save(this.beneficiadoMapper.fromDTO(dto)));
    }

    @Override
    public BeneficiadoDTO update(BeneficiadoDTO dto) {
        boolean exists = this.beneficiadoRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.beneficiadoMapper.toDTO(this.beneficiadoRepository.save(this.beneficiadoMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.beneficiadoRepository.existsById(id);
        if(exists){
            this.beneficiadoRepository.deleteById(id);
        }
    }
}
