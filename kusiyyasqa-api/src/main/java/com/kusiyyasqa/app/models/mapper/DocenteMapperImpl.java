package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.DocenteDTO;
import com.kusiyyasqa.app.models.entity.Docente;
import com.kusiyyasqa.app.models.mapper.contracts.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class DocenteMapperImpl implements DocenteMapper {

    private final ClaseMapper claseMapper;
    private final NacionalidadMapper nacionalidadMapper;
    private final SeguroMapper seguroMapper;
    private final SectorMapper sectorMapper;

    public DocenteMapperImpl(ClaseMapper claseMapper, NacionalidadMapper nacionalidadMapper, SeguroMapper seguroMapper, SectorMapper sectorMapper) {
        this.claseMapper = claseMapper;
        this.nacionalidadMapper = nacionalidadMapper;
        this.seguroMapper = seguroMapper;
        this.sectorMapper = sectorMapper;
    }

    @Override
    public Docente fromDTO(DocenteDTO dto) {
        Docente docente = null;
        if(dto != null){
            docente = new Docente();
            docente.setId(dto.getId());
            docente.setNombres(dto.getNombres());
            docente.setApellidoPaterno(dto.getApellidoPaterno());
            docente.setApellidoMaterno(dto.getApellidoMaterno());
            docente.setCelular(dto.getCelular());
            docente.setCodigo(dto.getCodigo());
            docente.setClaseList(dto.getClaseDTOList().stream().map(claseMapper::fromDTO).collect(Collectors.toList()));
            docente.setDireccion(dto.getDireccion());
            docente.setEmail(dto.getEmail());
            docente.setIdentificacion(dto.getIdentificacion());
            docente.setFechaNacimiento(dto.getFechaNacimiento());
            docente.setNacionalidad(nacionalidadMapper.fromDTO(dto.getNacionalidad()));
            docente.setTelefono(dto.getTelefono());
            docente.setSector(sectorMapper.fromDTO(dto.getSector()));
            docente.setSeguro(seguroMapper.fromDTO(dto.getSeguroDTO()));
        }
        return docente;
    }

    @Override
    public DocenteDTO toDTO(Docente entity) {
        DocenteDTO docente = null;
        if(entity != null){
            docente = new DocenteDTO();
            docente.setId(entity.getId());
            docente.setNombres(entity.getNombres());
            docente.setApellidoPaterno(entity.getApellidoPaterno());
            docente.setApellidoMaterno(entity.getApellidoMaterno());
            docente.setCelular(entity.getCelular());
            docente.setCodigo(entity.getCodigo());
            docente.setClaseDTOList(entity.getClaseList().stream().map(claseMapper::toDTO).collect(Collectors.toList()));
            docente.setDireccion(entity.getDireccion());
            docente.setEmail(entity.getEmail());
            docente.setIdentificacion(entity.getIdentificacion());
            docente.setFechaNacimiento(entity.getFechaNacimiento());
            docente.setNacionalidad(nacionalidadMapper.toDTO(entity.getNacionalidad()));
            docente.setTelefono(entity.getTelefono());
            docente.setSector(sectorMapper.toDTO(entity.getSector()));
            docente.setSeguroDTO(seguroMapper.toDTO(entity.getSeguro()));
        }
        return docente;
    }
}
