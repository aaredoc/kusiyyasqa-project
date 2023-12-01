package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.DonativoDTO;
import com.kusiyyasqa.app.models.entity.Donativo;
import com.kusiyyasqa.app.models.mapper.contracts.AportanteMapper;
import com.kusiyyasqa.app.models.mapper.contracts.DonativoMapper;
import org.springframework.stereotype.Component;

@Component
public class DonativoMapperImpl implements DonativoMapper {

    private final AportanteMapper aportanteMapper;

    public DonativoMapperImpl(AportanteMapper aportanteMapper) {
        this.aportanteMapper = aportanteMapper;
    }

    @Override
    public Donativo fromDTO(DonativoDTO dto) {
        Donativo donativo = null;
        if(dto != null){
            donativo = new Donativo();
            donativo.setId(dto.getId());
            donativo.setMonto(dto.getMonto());
            donativo.setDescripcion(dto.getDescripcion());
            donativo.setFecha(dto.getFecha());
            donativo.setAportante(aportanteMapper.fromDTO(dto.getAportanteDTO()));
        }
        return donativo;
    }

    @Override
    public DonativoDTO toDTO(Donativo entity) {
        DonativoDTO donativo = null;
        if(entity != null){
            donativo = new DonativoDTO();
            donativo.setId(entity.getId());
            donativo.setMonto(entity.getMonto());
            donativo.setDescripcion(entity.getDescripcion());
            donativo.setFecha(entity.getFecha());
            donativo.setAportanteDTO(aportanteMapper.toDTO(entity.getAportante()));
        }
        return donativo;
    }
}
