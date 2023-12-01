package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.CertificadoDTO;
import com.kusiyyasqa.app.models.mapper.contracts.CertificadoMapper;
import com.kusiyyasqa.app.repository.CertificadoRepository;
import com.kusiyyasqa.app.service.contracts.CertificadoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CertificadoServiceImpl implements CertificadoService {

    private final CertificadoRepository certificadoRepository;
    private final CertificadoMapper certificadoMapper;

    public CertificadoServiceImpl(CertificadoRepository certificadoRepository, CertificadoMapper certificadoMapper) {
        this.certificadoRepository = certificadoRepository;
        this.certificadoMapper = certificadoMapper;
    }


    @Override
    public List<CertificadoDTO> findAll() {
        return this.certificadoRepository.findAll()
                .stream()
                .map(this.certificadoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CertificadoDTO findById(Long id) {
        return this.certificadoMapper.toDTO(this.certificadoRepository.findById(id).orElse(null));

    }

    @Override
    public CertificadoDTO save(CertificadoDTO dto) {
        return this.certificadoMapper.toDTO(certificadoRepository.save(this.certificadoMapper.fromDTO(dto)));

    }

    @Override
    public CertificadoDTO update(CertificadoDTO dto) {
        boolean exists = this.certificadoRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.certificadoMapper.toDTO(this.certificadoRepository.save(this.certificadoMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.certificadoRepository.existsById(id);
        if(exists){
            this.certificadoRepository.deleteById(id);
        }
    }
}
