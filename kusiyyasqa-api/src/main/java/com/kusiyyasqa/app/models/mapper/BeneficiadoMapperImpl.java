package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.BeneficiadoDTO;
import com.kusiyyasqa.app.models.entity.Beneficiado;
import com.kusiyyasqa.app.models.mapper.contracts.*;
import org.springframework.stereotype.Component;

@Component
public class BeneficiadoMapperImpl implements BeneficiadoMapper {

    private final ClaseMapper claseMapper;
    private final SeguroMapper seguroMapper;
    private final SectorMapper sectorMapper;
    private final NacionalidadMapper nacionalidadMapper;

    public BeneficiadoMapperImpl(ClaseMapper claseMapper, SeguroMapper seguroMapper, SectorMapper sectorMapper, NacionalidadMapper nacionalidadMapper) {
        this.claseMapper = claseMapper;
        this.seguroMapper = seguroMapper;
        this.sectorMapper = sectorMapper;
        this.nacionalidadMapper = nacionalidadMapper;
    }

    @Override
    public Beneficiado fromDTO(BeneficiadoDTO dto) {
        Beneficiado beneficiado = null;
        if(dto != null){
            beneficiado = new Beneficiado();
            beneficiado.setId(dto.getId());
            beneficiado.setNombres(dto.getNombres());
            beneficiado.setApellidoPaterno(dto.getApellidoPaterno());
            beneficiado.setApellidoMaterno(dto.getApellidoMaterno());
            beneficiado.setDireccion(dto.getDireccion());
            beneficiado.setEmail(dto.getEmail());
            beneficiado.setCelular(dto.getCelular());
            beneficiado.setTelefono(dto.getTelefono());
            beneficiado.setFechaNacimiento(dto.getFechaNacimiento());
            beneficiado.setCodigo(dto.getCodigo());
            beneficiado.setEstado(dto.getEstado());
            beneficiado.setClase(claseMapper.fromDTO(dto.getClaseDTO()));
            beneficiado.setIdentificacion(dto.getIdentificacion());
            beneficiado.setSeguro(seguroMapper.fromDTO(dto.getSeguroDTO()));
            beneficiado.setSector(sectorMapper.fromDTO(dto.getSector()));
            beneficiado.setNacionalidad(nacionalidadMapper.fromDTO(dto.getNacionalidad()));
        }
        return beneficiado;
    }

    @Override
    public BeneficiadoDTO toDTO(Beneficiado entity) {
        BeneficiadoDTO beneficiado = null;
        if(entity != null){
            beneficiado = new BeneficiadoDTO();
            beneficiado.setId(entity.getId());
            beneficiado.setNombres(entity.getNombres());
            beneficiado.setApellidoPaterno(entity.getApellidoPaterno());
            beneficiado.setApellidoMaterno(entity.getApellidoMaterno());
            beneficiado.setDireccion(entity.getDireccion());
            beneficiado.setEmail(entity.getEmail());
            beneficiado.setCelular(entity.getCelular());
            beneficiado.setTelefono(entity.getTelefono());
            beneficiado.setFechaNacimiento(entity.getFechaNacimiento());
            beneficiado.setCodigo(entity.getCodigo());
            beneficiado.setEstado(entity.getEstado());
            beneficiado.setClaseDTO(claseMapper.toDTO(entity.getClase()));
            beneficiado.setIdentificacion(entity.getIdentificacion());
            beneficiado.setSeguroDTO(seguroMapper.toDTO(entity.getSeguro()));
            beneficiado.setSector(sectorMapper.toDTO(entity.getSector()));
            beneficiado.setNacionalidad(nacionalidadMapper.toDTO(entity.getNacionalidad()));
        }
        return beneficiado;
    }
}
