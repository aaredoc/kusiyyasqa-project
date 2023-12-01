package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.AportanteDTO;
import com.kusiyyasqa.app.models.entity.Aportante;
import com.kusiyyasqa.app.models.mapper.contracts.AportanteMapper;
import org.springframework.stereotype.Component;

@Component
public class AportanteMapperImpl implements AportanteMapper {
    @Override
    public Aportante fromDTO(AportanteDTO dto) {
        Aportante aportante = null;
        if(dto != null){
            aportante = new Aportante();
            aportante.setId(dto.getId());
            aportante.setRuc(dto.getRuc());
            aportante.setEmail(dto.getEmail());
            aportante.setCelular(dto.getCelular());
            aportante.setNombres(dto.getNombres());
            aportante.setIdentificacion(dto.getIdentificacion());
            aportante.setApellidoPaterno(dto.getApellidoPaterno());
            aportante.setApellidoMaterno(dto.getApellidoMaterno());
            aportante.setTelefono(dto.getTelefono());
        }
        return aportante;
    }

    @Override
    public AportanteDTO toDTO(Aportante entity) {
        AportanteDTO aportante = null;
        if(entity != null){
            aportante = new AportanteDTO();
            aportante.setId(entity.getId());
            aportante.setRuc(entity.getRuc());
            aportante.setEmail(entity.getEmail());
            aportante.setCelular(entity.getCelular());
            aportante.setNombres(entity.getNombres());
            aportante.setIdentificacion(entity.getIdentificacion());
            aportante.setApellidoPaterno(entity.getApellidoPaterno());
            aportante.setApellidoMaterno(entity.getApellidoMaterno());
            aportante.setTelefono(entity.getTelefono());
        }
        return aportante;
    }
}
