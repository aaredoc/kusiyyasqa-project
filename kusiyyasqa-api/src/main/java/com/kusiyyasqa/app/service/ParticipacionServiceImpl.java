package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.ParticipacionDTO;
import com.kusiyyasqa.app.models.mapper.contracts.ParticipacionMapper;
import com.kusiyyasqa.app.repository.ParticipacionRepository;
import com.kusiyyasqa.app.service.contracts.ParticipacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipacionServiceImpl implements ParticipacionService {

    private final ParticipacionRepository participacionRepository;
    private final ParticipacionMapper participacionMapper;

    @Autowired
    public ParticipacionServiceImpl(ParticipacionRepository participacionRepository, ParticipacionMapper participacionMapper) {
        this.participacionRepository = participacionRepository;
        this.participacionMapper = participacionMapper;
    }

    @Override
    public List<ParticipacionDTO> findAll() {
        return this.participacionRepository.findAll()
                .stream()
                .map(this.participacionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParticipacionDTO findById(Long id) {
        return this.participacionMapper.toDTO(this.participacionRepository.findById(id).orElse(null));
    }

    @Override
    public ParticipacionDTO save(ParticipacionDTO dto) {
        return this.participacionMapper.toDTO(participacionRepository.save(this.participacionMapper.fromDTO(dto)));
    }

    @Override
    public ParticipacionDTO update(ParticipacionDTO dto) {
        boolean exists = this.participacionRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.participacionMapper.toDTO(this.participacionRepository.save(this.participacionMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.participacionRepository.existsById(id);
        if(exists){
            this.participacionRepository.deleteById(id);
        }
    }
}
