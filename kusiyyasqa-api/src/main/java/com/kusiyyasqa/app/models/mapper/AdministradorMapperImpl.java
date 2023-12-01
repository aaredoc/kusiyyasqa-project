package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.AdministradorDTO;
import com.kusiyyasqa.app.models.entity.Administrador;
import com.kusiyyasqa.app.models.mapper.contracts.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AdministradorMapperImpl implements AdministradorMapper {
    private final AnuncioMapper anuncioMapper;
    private final DonativoMapper donativoMapper;
    private final ParticipacionMapper participacionMapper;
    private final NacionalidadMapper nacionalidadMapper;
    private final SectorMapper sectorMapper;
    private final SeguroMapper seguroMapper;

    public AdministradorMapperImpl(AnuncioMapper anuncioMapper, DonativoMapper donativoMapper, ParticipacionMapper participacionMapper, NacionalidadMapper nacionalidadMapper, SectorMapper sectorMapper, SeguroMapper seguroMapper) {
        this.anuncioMapper = anuncioMapper;
        this.donativoMapper = donativoMapper;
        this.participacionMapper = participacionMapper;
        this.nacionalidadMapper = nacionalidadMapper;
        this.sectorMapper = sectorMapper;
        this.seguroMapper = seguroMapper;
    }

    @Override
    public Administrador fromDTO(AdministradorDTO dto) {
        Administrador administrador = null;
        if(dto != null){
            administrador = new Administrador();
            administrador.setId(dto.getId());
            administrador.setUsername(dto.getUsername());
            administrador.setPassword(dto.getPassword());
            administrador.setAnuncioList(dto.getAnuncioDTOList().stream().map(anuncioMapper::fromDTO).collect(Collectors.toList()));
            administrador.setDonativoList(dto.getDonativoDTOList().stream().map(donativoMapper::fromDTO).collect(Collectors.toList()));
            administrador.setParticipacionList(dto.getParticipacionDTOList().stream().map(participacionMapper::fromDTO).collect(Collectors.toList()));
            administrador.setNombres(dto.getNombres());
            administrador.setCodigo(dto.getCodigo());
            administrador.setCelular(dto.getCelular());
            administrador.setApellidoPaterno(dto.getApellidoPaterno());
            administrador.setApellidoMaterno(dto.getApellidoMaterno());
            administrador.setEmail(dto.getEmail());
            administrador.setDireccion(dto.getDireccion());
            administrador.setFechaNacimiento(dto.getFechaNacimiento());
            administrador.setIdentificacion(dto.getIdentificacion());
            administrador.setNacionalidad(nacionalidadMapper.fromDTO(dto.getNacionalidad()));
            administrador.setSector(sectorMapper.fromDTO(dto.getSector()));
            administrador.setSeguro(seguroMapper.fromDTO(dto.getSeguroDTO()));
            administrador.setTelefono(dto.getTelefono());
            administrador.setEnabled(dto.isEnabled());
        }
        return administrador;
    }

    @Override
    public AdministradorDTO toDTO(Administrador entity) {
        AdministradorDTO administrador = null;
        if(entity != null){
            administrador = new AdministradorDTO();
            administrador.setId(entity.getId());
            administrador.setUsername(entity.getUsername());
            administrador.setPassword(entity.getPassword());
            administrador.setAnuncioDTOList(entity.getAnuncioList().stream().map(anuncioMapper::toDTO).collect(Collectors.toList()));
            administrador.setDonativoDTOList(entity.getDonativoList().stream().map(donativoMapper::toDTO).collect(Collectors.toList()));
            administrador.setParticipacionDTOList(entity.getParticipacionList().stream().map(participacionMapper::toDTO).collect(Collectors.toList()));
            administrador.setNombres(entity.getNombres());
            administrador.setCodigo(entity.getCodigo());
            administrador.setCelular(entity.getCelular());
            administrador.setApellidoPaterno(entity.getApellidoPaterno());
            administrador.setApellidoMaterno(entity.getApellidoMaterno());
            administrador.setEmail(entity.getEmail());
            administrador.setDireccion(entity.getDireccion());
            administrador.setFechaNacimiento(entity.getFechaNacimiento());
            administrador.setIdentificacion(entity.getIdentificacion());
            administrador.setNacionalidad(nacionalidadMapper.toDTO(entity.getNacionalidad()));
            administrador.setSector(sectorMapper.toDTO(entity.getSector()));
            administrador.setSeguroDTO(seguroMapper.toDTO(entity.getSeguro()));
            administrador.setTelefono(entity.getTelefono());
            administrador.setEnabled(entity.isEnabled());
        }
        return administrador;
    }
}
