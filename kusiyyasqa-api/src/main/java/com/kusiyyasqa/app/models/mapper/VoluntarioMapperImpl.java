package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.VoluntarioDTO;
import com.kusiyyasqa.app.models.entity.Voluntario;
import com.kusiyyasqa.app.models.mapper.contracts.NacionalidadMapper;
import com.kusiyyasqa.app.models.mapper.contracts.ParticipacionMapper;
import com.kusiyyasqa.app.models.mapper.contracts.SectorMapper;
import com.kusiyyasqa.app.models.mapper.contracts.VoluntarioMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class VoluntarioMapperImpl implements VoluntarioMapper {

    private final ParticipacionMapper participacionMapper;
    private final NacionalidadMapper nacionalidadMapper;
    private final SectorMapper sectorMapper;

    public VoluntarioMapperImpl(ParticipacionMapper participacionMapper, NacionalidadMapper nacionalidadMapper, SectorMapper sectorMapper) {
        this.participacionMapper = participacionMapper;
        this.nacionalidadMapper = nacionalidadMapper;
        this.sectorMapper = sectorMapper;
    }

    @Override
    public Voluntario fromDTO(VoluntarioDTO dto) {
        Voluntario voluntario = null;
        if(dto != null){
            voluntario = new Voluntario();
            voluntario.setId(dto.getId());
            voluntario.setApellidoPaterno(dto.getApellidoPaterno());
            voluntario.setApellidoMaterno(dto.getApellidoMaterno());
            voluntario.setDireccion(dto.getDireccion());
            voluntario.setCelular(dto.getCelular());
            voluntario.setParticipacionList(dto.getParticipacionList().stream().map(participacionMapper::fromDTO).collect(Collectors.toList()));
            voluntario.setEmail(dto.getEmail());
            voluntario.setIdentificacion(dto.getIdentificacion());
            voluntario.setNacionalidad(nacionalidadMapper.fromDTO(dto.getNacionalidad()));
            voluntario.setSector(sectorMapper.fromDTO(dto.getSector()));
            voluntario.setFechaNacimiento(dto.getFechaNacimiento());
            voluntario.setTelefono(dto.getTelefono());
        }
        return voluntario;
    }

    @Override
    public VoluntarioDTO toDTO(Voluntario entity) {
        VoluntarioDTO voluntario = null;
        if(entity != null){
            voluntario = new VoluntarioDTO();
            voluntario.setId(entity.getId());
            voluntario.setApellidoPaterno(entity.getApellidoPaterno());
            voluntario.setApellidoMaterno(entity.getApellidoMaterno());
            voluntario.setDireccion(entity.getDireccion());
            voluntario.setCelular(entity.getCelular());
            voluntario.setParticipacionList(entity.getParticipacionList().stream().map(participacionMapper::toDTO).collect(Collectors.toList()));
            voluntario.setEmail(entity.getEmail());
            voluntario.setIdentificacion(entity.getIdentificacion());
            voluntario.setNacionalidad(nacionalidadMapper.toDTO(entity.getNacionalidad()));
            voluntario.setSector(sectorMapper.toDTO(entity.getSector()));
            voluntario.setFechaNacimiento(entity.getFechaNacimiento());
            voluntario.setTelefono(entity.getTelefono());
        }
        return voluntario;
    }
}
