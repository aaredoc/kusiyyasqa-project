package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.TutorDTO;
import com.kusiyyasqa.app.models.entity.Tutor;
import com.kusiyyasqa.app.models.mapper.contracts.NacionalidadMapper;
import com.kusiyyasqa.app.models.mapper.contracts.ParentescoMapper;
import com.kusiyyasqa.app.models.mapper.contracts.SectorMapper;
import com.kusiyyasqa.app.models.mapper.contracts.TutorMapper;
import org.springframework.stereotype.Component;

@Component
public class TutorMapperImpl implements TutorMapper {

    private final ParentescoMapper parentescoMapper;
    private final NacionalidadMapper nacionalidadMapper;
    private final SectorMapper sectorMapper;

    public TutorMapperImpl(ParentescoMapper parentescoMapper, NacionalidadMapper nacionalidadMapper, SectorMapper sectorMapper) {
        this.parentescoMapper = parentescoMapper;
        this.nacionalidadMapper = nacionalidadMapper;
        this.sectorMapper = sectorMapper;
    }

    @Override
    public Tutor fromDTO(TutorDTO dto) {
        Tutor tutor = null;
        if(dto != null){
            tutor = new Tutor();
            tutor.setId(dto.getId());
            tutor.setNombres(dto.getNombres());
            tutor.setApellidoPaterno(dto.getApellidoPaterno());
            tutor.setApellidoMaterno(dto.getApellidoMaterno());
            tutor.setDireccion(dto.getDireccion());
            tutor.setCelular(dto.getCelular());
            tutor.setEmail(dto.getEmail());
            tutor.setFechaNacimiento(dto.getFechaNacimiento());
            tutor.setIdentificacion(dto.getIdentificacion());
            tutor.setTelefono(dto.getTelefono());
            tutor.setCompromiso(dto.getCompromiso());
            tutor.setParentesco(parentescoMapper.fromDTO(dto.getParentescoDTO()));
            tutor.setNacionalidad(nacionalidadMapper.fromDTO(dto.getNacionalidad()));
            tutor.setSector(sectorMapper.fromDTO(dto.getSector()));
        }
        return tutor;
    }

    @Override
    public TutorDTO toDTO(Tutor entity) {
        TutorDTO tutor = null;
        if(entity != null){
            tutor = new TutorDTO();
            tutor.setId(entity.getId());
            tutor.setNombres(entity.getNombres());
            tutor.setApellidoPaterno(entity.getApellidoPaterno());
            tutor.setApellidoMaterno(entity.getApellidoMaterno());
            tutor.setDireccion(entity.getDireccion());
            tutor.setCelular(entity.getCelular());
            tutor.setEmail(entity.getEmail());
            tutor.setFechaNacimiento(entity.getFechaNacimiento());
            tutor.setIdentificacion(entity.getIdentificacion());
            tutor.setTelefono(entity.getTelefono());
            tutor.setCompromiso(entity.getCompromiso());
            tutor.setParentescoDTO(parentescoMapper.toDTO(entity.getParentesco()));
            tutor.setNacionalidad(nacionalidadMapper.toDTO(entity.getNacionalidad()));
            tutor.setSector(sectorMapper.toDTO(entity.getSector()));
        }
        return tutor;
    }
}
